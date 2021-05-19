create or replace  PROCEDURE  crearcalendario AS        
    BEGIN
        DECLARE
             CURSOR C
             IS 
             SELECT e1.ID_EQUIPO AS eq_local, e2.ID_EQUIPO AS eq_visitante
             FROM equipo e1, equipo e2 
             WHERE e1.ID_EQUIPO <> e2.ID_EQUIPO;
             v_cursor C%ROWTYPE;
             
             CURSOR D 
             IS
             SELECT NUM_JORNADA 
             FROM JORNADA ;
             v_jornada D%ROWTYPE;
             v_partido partido.ID_PARTIDO%TYPE;
        v_cant number;
        BEGIN
        FOR v_jornada IN D
           LOOP
             FOR v_cursor IN C
           LOOP
           select ID_PARTIDO into v_partido
           from partido p, jornada j 
           WHERE p.NUM_JORNADA=v_jornada.NUM_JORNADA 
           AND ID_EQUIPOL  in (v_cursor.eq_local , v_cursor.eq_visitante)
           OR ID_EQUIPOV  in (v_cursor.eq_local , v_cursor.eq_visitante);
           IF NOTFOUND then
           INSERT INTO PARTIDO(HORA, RESULTADOL,resultadov,num_jornada,id_equipol,id_equipov) VALUES('12/06/21 18:50:00',null,null,v_jornada.NUM_JORNADA,v_cursor.eq_local,v_cursor.eq_visitante);
           end IF;
           END LOOP;
          END LOOP; 
       END;
     END;