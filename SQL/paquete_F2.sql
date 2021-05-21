SET SERVEROUTPUT ON;
CREATE OR REPLACE PACKAGE pk_consultasEquipoJugador AS
    PROCEDURE  informaciones_equipo;
    PROCEDURE  informaciones_jugador;
    function ver_victoriaL (p_id_equipo number)return number;
    PROCEDURE  cantidad_victorias;
END pk_consultasEquipoJugador;



CREATE OR REPLACE PACKAGE BODY pk_consultasEquipoJugador AS

  PROCEDURE  informaciones_equipo AS        
    BEGIN
        DECLARE
             CURSOR C
             IS SELECT id_equipo,nombre
             FROM  equipo;
             
            v_cursor C%ROWTYPE;
        BEGIN
             FOR v_cursor IN C
           LOOP
             DBMS_OUTPUT.PUT_LINE
               ('LA ID DEL EQUIPO ES : '||v_cursor.ID_EQUIPO ||
               ' EL NOMBRE DEL EQUIPO ES : ' || v_cursor.NOMBRE);
           END LOOP;
        END;
     END;

 
  
  
  
   PROCEDURE informaciones_jugador AS 
   BEGIN 
        DECLARE
             CURSOR J
             IS SELECT *
             FROM jugador;
             
            v_cursor J%ROWTYPE;
        BEGIN
             FOR v_cursor IN J
           LOOP
             DBMS_OUTPUT.PUT_LINE
               ('LA ID DEL JUGADOR ES : '|| v_cursor.id_jugador ||chr(10)||
               ' EL NOMBRE DEL JUGADOR ES : ' || v_cursor.NOMBRE||chr(10)||
               ' EL SUELDO DEL JUGADOR ES : ' || TO_CHAR(v_cursor.SUELDO)||chr(10)||
               ' EL NICKNAME DEL JUGADOR ES : ' || v_cursor.NICKNAME||chr(10)||
               ' EL TELEFONE DEL JUGADOR ES : ' || v_cursor.TELEFONO||chr(10)||
               ' EL NACIONALIDAD DEL JUGADOR ES : ' || v_cursor.NACIONALIDAD||chr(10)||
               ' EL ROL DEL JUGADOR ES : ' || v_cursor.ROL||chr(10)||
               ' EL ID_EQUIPO DEL JUGADOR ES : ' || TO_CHAR(v_cursor.ID_EQUIPO));
           END LOOP;
        END;
   END;  
   function ver_victoriaL (p_id_equipo number) Return number
as

BEGIN
     declare 
        Puntos_local number;
        Puntos_visitante number;
        Victoria_total number;
    begin
        select count(*) into Puntos_local 
        from partido
        wHERE id_equipol = p_id_equipo
        AND ResultadoL = '3';
        select count(*) into Puntos_visitante 
        from partido
        where ID_EQUIPOV = p_id_equipo
        AND ResultadoV ='3';
        Victoria_total:=Puntos_local+Puntos_visitante;
        return Victoria_total;
    end;
END ver_victoria;

PROCEDURE  cantidad_victorias AS        
    BEGIN
        DECLARE
             CURSOR C
             IS SELECT id_equipo
             FROM  equipo;
             
            v_cursor C%ROWTYPE;
            v_victoria number;
        BEGIN
             FOR v_cursor IN C
           LOOP
           v_victoria:=ver_victoriaL(v_cursor.ID_EQUIPO);
             DBMS_OUTPUT.PUT_LINE
               ('LA ID DEL EQUIPO ES : '||v_cursor.ID_EQUIPO ||
               ' HAN GANADO : ' || v_victoria||' PARTIDOS');
           END LOOP;
        END;
     END;
END pk_consultasEquipoJugador;

select * from JUGADOR;
select * from pARTIDO;
select * from equipo;


SET SERVEROUTPUT ON;
CREATE OR REPLACE PACKAGE generar_liga AS
    PROCEDURE  crearjornadas;
    PROCEDURE  informaciones_jugador;
    function hora (p_jornada number) Return date;
    PROCEDURE  crearcalendario;
END generar_liga;



CREATE OR REPLACE PACKAGE BODY generar_liga AS
             
 PROCEDURE  crearjornadas AS 
v_count number(2):=0;
v_bucle number(2):=0;
v_fecha date;
    BEGIN 
    delete from jornada;
       SELECT count(*)-1 into v_count FROM  equipo;
       INSERT INTO JORNADA(FECHA) VALUES(sysdate+28); 
       while v_bucle <= 2*v_count LOOP
        SELECT FECHA INTO v_fecha from JORNADA WHERE NUM_JORNADA=(select MAX(NUM_JORNADA)from jornada ) ;
        INSERT INTO JORNADA(FECHA) VALUES(v_fecha+7); 
        v_bucle:=v_bucle+1;
        END LOOP;  
     END;

function hora (p_jornada number) Return date
as
        dia_partido date;
        cant_partidos number;
        hora_partido date;
    begin
        select fecha into dia_partido 
        from  jornada 
        WHERE  NUM_JORNADA=p_jornada;
        select count(*) into cant_partidos 
        from partido
        where NUM_JORNADA=p_jornada;
        hora_partido:=dia_partido+ (cant_partidos+12)/24;
        return hora_partido;
END hora;

PROCEDURE  crearcalendario AS        
    BEGIN
        DECLARE
             CURSOR C
             IS 
             SELECT e1.ID_EQUIPO AS eq_local, e2.ID_EQUIPO AS eq_visitante
             FROM equipo e1, equipo e2 
             WHERE e1.ID_EQUIPO <> e2.ID_EQUIPO;
             v_cursor C%ROWTYPE;
             
             v_max_jornada JORNADA.NUM_JORNADA%TYPE;
             v_jornada JORNADA.NUM_JORNADA%TYPE;
             v_partidoL partido.ID_PARTIDO%TYPE;
             v_partidoV partido.ID_PARTIDO%TYPE;
        v_cant date;
        BEGIN
        SELECT max(NUM_JORNADA )into v_max_jornada
             FROM JORNADA ;
           FOR v_cursor IN C
           LOOP
            SELECT min(NUM_JORNADA ) into v_jornada
             FROM JORNADA ;
           while  v_jornada<=v_max_jornada
           LOOP
           v_cant:=hora(v_jornada);
           select max(p.id_partido) into v_partidol
           from partido p, jornada j 
           WHERE p.NUM_JORNADA=v_jornada
           AND (ID_EQUIPOL IN (v_cursor.eq_visitante,v_cursor.eq_local)
           OR ID_EQUIPOV IN(v_cursor.eq_visitante,v_cursor.eq_local));
           select max(p.id_partido) into v_partidov
           from partido p, jornada j 
           WHERE (ID_EQUIPOL=v_cursor.eq_local 
           AND ID_EQUIPOV  =v_cursor.eq_visitante ) ;
           IF (v_partidoL is null and v_partidoV is null)  then
           INSERT INTO PARTIDO(HORA, RESULTADOL,resultadov,num_jornada,id_equipol,id_equipov) VALUES(v_cant,'','',v_jornada,v_cursor.eq_local,v_cursor.eq_visitante);
           end IF;
           v_jornada:=v_jornada+1;
           END LOOP;
           END LOOP;
       END;
     END crearcalendario;