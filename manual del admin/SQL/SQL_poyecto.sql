-------------------Eliminacion de tablas y sus constraints----------------------
DROP TABLE JUGADOR CASCADE CONSTRAINTS;
DROP TABLE ENTRENADOR CASCADE CONSTRAINTS;
DROP TABLE ASISTENTE CASCADE CONSTRAINTS;
DROP TABLE EQUIPO CASCADE CONSTRAINTS;
DROP TABLE DUENO CASCADE CONSTRAINTS;
DROP TABLE JORNADA CASCADE CONSTRAINTS;
DROP TABLE PARTIDO CASCADE CONSTRAINTS;
DROP TABLE ADMINISTRADOR CASCADE CONSTRAINTS;
DROP TABLE USUARIO CASCADE CONSTRAINTS; 


-------------------Creacion de las tablas---------------------------------------
CREATE TABLE ADMINISTRADOR (
	COD_ADMIN NUMBER(4) GENERATED AS IDENTITY(
									START WITH 1
									INCREMENT BY 1
									MAXVALUE 1000
									NOCYCLE
						),
	NOMBRE VARCHAR2(20),
	CORREO VARCHAR2(30),
	CONTRASENA VARCHAR2(20),
	CONSTRAINT ADM_PK PRIMARY KEY(COD_ADMIN)
);
 
CREATE TABLE USUARIO (
	COD_USUARIO NUMBER(4) GENERATED AS IDENTITY(
									START WITH 1
									INCREMENT BY 1
									MAXVALUE 1000
									NOCYCLE
						),
	NOMBRE VARCHAR2(20),
	CORREO VARCHAR2(30),
	CONTRASENA VARCHAR2(20),
	CONSTRAINT USU_PK PRIMARY KEY(COD_USUARIO)
);

CREATE TABLE EQUIPO(
	ID_EQUIPO NUMBER(4) GENERATED AS IDENTITY(
									START WITH 1
									INCREMENT BY 1
									MAXVALUE 1000
									NOCYCLE
		),
	NOMBRE VARCHAR2(20),
	ESCUDO VARCHAR2(50),
	CONSTRAINT EQU_PK PRIMARY KEY(ID_EQUIPO)		
);

CREATE TABLE ENTRENADOR (
	ID_ENTRENADOR NUMBER(4) GENERATED AS IDENTITY(
									START WITH 1
									INCREMENT BY 1
									MAXVALUE 1000
									NOCYCLE
		),
	NOMBRE VARCHAR2(20),
	SUELDO NUMBER(6),
	TELEFONO VARCHAR2(20),
	NACIONALIDAD VARCHAR2(20),
	ID_EQUIPO NUMBER(4),
	CONSTRAINT ENT_PK PRIMARY KEY(ID_ENTRENADOR),
	CONSTRAINT NET_EQU_FK FOREIGN KEY (ID_EQUIPO)
				REFERENCES EQUIPO(ID_EQUIPO) ON DELETE CASCADE
);

CREATE TABLE ASISTENTE(
	ID_ASISTENTE NUMBER(4) GENERATED AS IDENTITY(
									START WITH 1
									INCREMENT BY 1
									MAXVALUE 1000
									NOCYCLE
					),
	NOMBRE VARCHAR2(20),
	SUELDO NUMBER(6),
	TELEFONO VARCHAR2(20),
	NACIONALIDAD VARCHAR2(20),
	CONSTRAINT ASI_PK PRIMARY KEY(ID_ASISTENTE),
	CONSTRAINT ASI_ENT_FK FOREIGN KEY (ID_ASISTENTE)
				REFERENCES ENTRENADOR(ID_ENTRENADOR) ON DELETE CASCADE
);




CREATE TABLE JUGADOR (
	ID_JUGADOR NUMBER(4) GENERATED AS IDENTITY(
									START WITH 1
									INCREMENT BY 1
									MAXVALUE 1000
									NOCYCLE
		),
	NOMBRE VARCHAR2(20),
	SUELDO NUMBER(6),
	NICKNAME VARCHAR2(20),
	TELEFONO VARCHAR2(20),
	NACIONALIDAD VARCHAR2(20),
	ROL VARCHAR2(30),
	ID_EQUIPO NUMBER(4),
	CONSTRAINT JUG_PK PRIMARY KEY(ID_JUGADOR),
	CONSTRAINT JUG_EQU_FK FOREIGN KEY (ID_EQUIPO)
				REFERENCES EQUIPO(ID_EQUIPO) ON DELETE CASCADE

);

CREATE TABLE DUENO (
	ID_DUENO NUMBER(4) GENERATED AS IDENTITY(
									START WITH 1
									INCREMENT BY 1
									MAXVALUE 1000
									NOCYCLE
		),
	NOMBRE VARCHAR2(20),
	NACIONALIDAD VARCHAR2(20),
	TELEFONO VARCHAR2(20),
	ID_EQUIPO NUMBER(4),
	CONSTRAINT DUE_PK PRIMARY KEY(ID_DUENO),
	CONSTRAINT DUE_EQU_FK FOREIGN KEY (ID_EQUIPO)
				REFERENCES EQUIPO(ID_EQUIPO) ON DELETE CASCADE
);


CREATE TABLE JORNADA (
	NUM_JORNADA NUMBER(4) GENERATED AS IDENTITY(
									START WITH 1
									INCREMENT BY 1
									MAXVALUE 1000
									NOCYCLE
		),
	FECHA DATE,
	CONSTRAINT JOR_PK PRIMARY KEY(NUM_JORNADA)
);

CREATE TABLE PARTIDO (
	ID_PARTIDO NUMBER(4) GENERATED AS IDENTITY(
									START WITH 1
									INCREMENT BY 1
									MAXVALUE 1000
									NOCYCLE
		),
	HORA TIMESTAMP,
	RESULTADOL VARCHAR2(24),
	RESULTADOV VARCHAR2(24),
	NUM_JORNADA NUMBER(4),
	ID_EQUIPOL NUMBER(4),
	ID_EQUIPOV NUMBER(4),
	CONSTRAINT PAR_PK PRIMARY KEY(ID_PARTIDO),
	CONSTRAINT PAR_JOR_FK FOREIGN KEY (NUM_JORNADA)
				REFERENCES JORNADA(NUM_JORNADA) ON DELETE CASCADE,
	CONSTRAINT PAR_EQUL_FK FOREIGN KEY (ID_EQUIPOL)
				REFERENCES EQUIPO(ID_EQUIPO) ON DELETE CASCADE,
	CONSTRAINT PAR_EQUV_FK FOREIGN KEY (ID_EQUIPOV)
				REFERENCES EQUIPO(ID_EQUIPO) ON DELETE CASCADE
);


----Trigger en la cual evitamos que un equipo pueda tener mas de 6 jugadores----
CREATE OR REPLACE TRIGGER NUM_MAX_JUGADORES
BEFORE INSERT OR UPDATE ON JUGADOR
FOR EACH ROW
DECLARE
    V_CANT_JUGADORES NUMBER(1);
    cursor P_CURSOR is
    SELECT COUNT(ID_EQUIPO)
    from JUGADOR
    group by id_equipo
    having id_equipo = :NEW.ID_EQUIPO;
    
BEGIN
    OPEN P_CURSOR;
    FETCH P_CURSOR INTO V_CANT_JUGADORES;
    IF(V_CANT_JUGADORES >= 6)THEN
        RAISE_APPLICATION_ERROR('-20000','No puede haber mas de 6 jugadores');
    END IF;
    CLOSE P_CURSOR;
END;

----Trigger en la cual evitamos que el sueldo de un jugador sea menor al SMI----
CREATE OR REPLACE TRIGGER sueldoJugador
BEFORE INSERT OR UPDATE OF sueldo ON jugador
FOR EACH ROW
DECLARE
    v_sInterP jugador.sueldo%type:=950;
BEGIN
-- usando los Pseudo-Registros :old y :new se pueden registrar 
--los valores antiguos y los nuevos. 

IF :NEW.sueldo < v_sinterp
THEN raise_application_error
(-20600,('El salario '|| to_char(:new.sueldo)||
    ' no se puede ser menor que '|| v_sinterp));
END IF;
END;

----Trigger en la cual evita el salario anual maximo de 200.000� por equipo----
CREATE OR REPLACE TRIGGER MAX_SAL_ANUAL
AFTER INSERT ON JUGADOR
FOR EACH ROW
DECLARE
    V_MAX_SUELDO_ANUAL_JUG NUMBER(1);
    CURSOR MAX_SUELDO_ANUAL_JUG IS
    SELECT SUM(SUELDO)*14 AS "SUELDO ANUAL"
    FROM JUGADOR
    GROUP BY ID_EQUIPO
    HAVING ID_EQUIPO = :new.ID_EQUIPO;
BEGIN 
    OPEN MAX_SUELDO_ANUAL_JUG;
    FETCH MAX_SUELDO_ANUAL_JUG INTO V_MAX_SUELDO_ANUAL_JUG;
     IF(V_MAX_SUELDO_ANUAL_JUG >= 200000)THEN
        RAISE_APPLICATION_ERROR('-20001','No se puede superar el maximo salario anual');
    END IF;
    CLOSE max_sueldo_anual_JUG;
END;

*/

----Trigger en la cual evita crear un calendario cuando algun equipo tenga menos de 2 jugadores----
CREATE OR REPLACE TRIGGER CREAR_CALENDARIO
BEFORE INSERT OR UPDATE ON PARTIDO
FOR EACH ROW
DECLARE
    V_CANT_JUGADOR NUMBER(1);
    cursor P_CURSOR is
    SELECT COUNT(*)
    from JUGADOR
    group by id_equipo;
    
BEGIN
    OPEN P_CURSOR;
    FETCH P_CURSOR INTO V_CANT_JUGADOR;
    WHILE P_CURSOR%FOUND LOOP
    IF(V_CANT_JUGADOR <2)THEN
        RAISE_APPLICATION_ERROR('-20000','Tiene que haber 2 jugadores en cada equipo');
    END IF;
    FETCH P_CURSOR INTO V_CANT_JUGADOR;
    END LOOP;
    CLOSE P_CURSOR;
END;

----Trigger en la cual evitamos a�adir o modificar jugadores una vez creado el calendario----
CREATE OR REPLACE TRIGGER restringir_equipo
   BEFORE INSERT OR UPDATE OR DELETE
   ON EQUIPO
   FOR EACH ROW
DECLARE
   calendario_iniciado   EXCEPTION;
   PRAGMA EXCEPTION_INIT (calendario_iniciado , -20001);
   n_cant      NUMBER (1);
BEGIN
   SELECT COUNT (*)
     INTO n_cant
     FROM partido;

   IF n_cant > 0 
   THEN
      RAISE calendario_iniciado;
   END IF;
EXCEPTION
   WHEN calendario_iniciado
   THEN
      raise_application_error (-20001, 'el calendario ya ha sido iniciado');
END;

----Trigger en la cual evitamos a�adir o modificar equipos una vez creado el calendario----
CREATE OR REPLACE TRIGGER restringir_jugador
   BEFORE INSERT OR UPDATE OR DELETE
   ON Jugador
   FOR EACH ROW
DECLARE
   calendario_iniciado   EXCEPTION;
   PRAGMA EXCEPTION_INIT (calendario_iniciado , -20001);
   n_cant      NUMBER (1);
BEGIN
   SELECT COUNT (*)
     INTO n_cant
     FROM partido;

   IF n_cant > 0
   THEN
      RAISE calendario_iniciado;
   END IF;
EXCEPTION
   WHEN calendario_iniciado
   THEN
      raise_application_error (-20001, 'el calendario ya ha sido iniciado');
END;

----------------------Insercion de datos en las tablas--------------------------
INSERT INTO EQUIPO(NOMBRE,ESCUDO) VALUES ('BLACK BIRDS','http://imagenescudoblackbirds.es');
INSERT INTO EQUIPO(NOMBRE,ESCUDO) VALUES ('MONSTERS','http://imagenescudocahinmosters.es');
INSERT INTO EQUIPO(NOMBRE,ESCUDO) VALUES ('PITUFOS','http://imagenescudolospitufos.es');
INSERT INTO EQUIPO(NOMBRE,ESCUDO) VALUES ('INCREIBLES','http://imagenescudolosincreibles.es');
INSERT INTO EQUIPO(NOMBRE,ESCUDO) VALUES ('LEG BROKERS','http://imagenescudolegbrokers.es');
INSERT INTO EQUIPO(NOMBRE,ESCUDO) VALUES ('ROMPEMUROS','http://imagenescudorompemuros.es');

INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('William',1200,'WIL','689456982','Ingelsa','PORTERO',1);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Luis',1500,'Luisito','689578912','Espa�ol','MEDIO CENTRO',1);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Manuel',2000,'Manu','689091482','Mexicano','LATERAN DERECHO',1);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Unai',1900,'U','689782342','Espa�ola','DELANTERO DERECHO',1);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Brayan',1300,'Bray','689754324','Arqentina','DELANTERO IZQUIERDO',2);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Casemiro',1100,'Cas','689662345','Francesa','MEDIO CENTRO',2);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Jose Antonio',1600,'JS','689456897','Espa�ola','PORTERO',2);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Pancho',980,'P','689456982','Francesa','MEDIO CENTRO',3);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Ruben',1000,'Ru','689456982','Francesa','DELANTERO DERECHO',3);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Bolonchin',1500,'Bola','689563123','Italinana','LATERAN DERECHO',4);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Edmond',1500,'Ed','689092471','Rusa','PORTERO',4);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Mondo',2500,'M','689789345','Africana','LATERAL IZQUIERDO',5);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Lamelon',1700,'Lame','689817234','Espa�ola','MEDIO CENTRO',5);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Cristiano',1500,'Cris','689001234','Francesa','DELNATERO IZQUIERDO',6);
INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES ('Messi',1800,'Mes','689457992','Argentina','DELANTERO DERECHO',6);

INSERT INTO ENTRENADOR(NOMBRE,SUELDO,TELEFONO,NACIONALIDAD,ID_EQUIPO) VALUES ('Guille',1200,'689237849','Espa�ol',1);
INSERT INTO ENTRENADOR(NOMBRE,SUELDO,TELEFONO,NACIONALIDAD,ID_EQUIPO) VALUES ('Ramon',1600,'689345215','Francesa',2);
INSERT INTO ENTRENADOR(NOMBRE,SUELDO,TELEFONO,NACIONALIDAD,ID_EQUIPO) VALUES ('Eduardo',1100,'689435676','Argentina',3);
INSERT INTO ENTRENADOR(NOMBRE,SUELDO,TELEFONO,NACIONALIDAD,ID_EQUIPO) VALUES ('Rafael',1200,'689998934','Africana',4);
INSERT INTO ENTRENADOR(NOMBRE,SUELDO,TELEFONO,NACIONALIDAD,ID_EQUIPO) VALUES ('Langosta',1200,'689112345','Rusa',5);
INSERT INTO ENTRENADOR(NOMBRE,SUELDO,TELEFONO,NACIONALIDAD,ID_EQUIPO) VALUES ('David',1200,'689773689','Alemana',6);

INSERT INTO ASISTENTE(NOMBRE,TELEFONO,NACIONALIDAD,SUELDO) VALUES ('Raul','689999887','Espa�ola',1000);
INSERT INTO ASISTENTE(NOMBRE,TELEFONO,NACIONALIDAD,SUELDO) VALUES ('Andrea','689456453','Italiana',1000);


INSERT INTO ADMINISTRADOR(CORREO,CONTRASE�A) VALUES('Juan','juanito456@gmail.com','12345Abcde');
INSERT INTO ADMINISTRADOR(CORREO,CONTRASE�A) VALUES('ander','labrava777@gmail.com','12345Abcde');
INSERT INTO ADMINISTRADOR(CORREO,CONTRASE�A) VALUES('sendy','labrava777@gmail.com','123');

INSERT INTO USUARIO(CORREO,CONTRASE�A) VALUES('miguel','minguilover55@gmail.com','54321Edcba');

set serveroutput on;
commit;