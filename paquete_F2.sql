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