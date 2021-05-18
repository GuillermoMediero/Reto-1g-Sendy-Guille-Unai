SET SERVEROUTPUT ON;
CREATE OR REPLACE PACKAGE Calendario AS
    PROCEDURE  crearjornadas;
    PROCEDURE  crearcalendario;
    function ver_res (p_resL number,p_resV number)return boolean;
    PROCEDURE  enviar_resultado(p_resL,p_resV);
    function ver_victoriaL (p_id_equipo number)return number;
    PROCEDURE  cantidad_victorias;
END pk_consultasEquipoJugador;



CREATE OR REPLACE PACKAGE BODY Calendario AS
PROCEDURE  crearjornadas AS    
v_count number; 
v_fecha date;

    BEGIN
       SELECT count(*)into v_count FROM equipos
        for (int i, i<v_count,i++){
        if(i=0)
        INSERT INTO JORNADA(FECHA) VALUES(sysdate);
        else
        {
        SELECT FECHA INTO v_fecha from JORNADA WHERE NUM_JORNADA=1
        }
         INSERT INTO JORNADA(FECHA) VALUES(v_fecha+7);
        }
            
        END;
     END;

  PROCEDURE  crearcalendario AS        
    BEGIN
        DECLARE
             CURSOR C
             IS 
             SELECT e1.ID_EQUIPO AS"eq_local",e2.ID_EQUIPO AS"eq_visitante" FROM equipo e1, equipo e2 WHERE e1.ID_EQUIPO <> e2.ID_EQUIPO;
             CURSOR D IS
             SELECT * FROM JORNADA ;
             v_jornada D%ROWTYPE
            v_cursor C%ROWTYPE;

        BEGIN
        FOR v_jornada IN D
           LOOP
             FOR v_cursor IN C
           LOOP
           if()
             DBMS_OUTPUT.PUT_LINE
               ('LA ID DEL EQUIPO ES : '||v_cursor.ID_EQUIPO ||
               ' EL NOMBRE DEL EQUIPO ES : ' || v_cursor.NOMBRE);
           END LOOP;
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