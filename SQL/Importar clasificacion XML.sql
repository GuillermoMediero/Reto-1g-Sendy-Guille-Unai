CREATE TABLE temp_clas_tab(RETURN CLOB)

DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
  result CLOB;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
              'CREATE OR REPLACE view clasificacion AS
  SELECT DISTINCT e.nombre,(
              SELECT count(*) 
              FROM PARTIDO 
              wHERE id_equipol = e.id_equipo
              OR ID_EQUIPOV = e.id_equipo
        ) AS PARTIDOS_JUGADOS ,(
              SELECT count(*) 
              FROM PARTIDO 
              WHERE (id_equipol = e.id_equipo AND ResultadoL = '3')
              OR (ID_EQUIPOV = e.id_equipo AND  ResultadoV ='3'))AS victorias ,
        (
              SELECT count(*) 
              FROM PARTIDO 
              WHERE (id_equipol = e.id_equipo AND ResultadoL <> '3')
              OR (ID_EQUIPOV = e.id_equipo AND  ResultadoV <>'3'))AS DERROTAS,
        (
             100*((
              SELECT count(*) 
              FROM PARTIDO 
              WHERE (id_equipol = e.id_equipo AND ResultadoL = '3')
              OR (ID_EQUIPOV = e.id_equipo AND  ResultadoV ='3'))/(
              SELECT count(*) 
              FROM PARTIDO 
              wHERE id_equipol = e.id_equipo
              OR ID_EQUIPOV = e.id_equipo
        )))AS PUNTOS 
            from equipo e, PARTIDO p
            WHERE e.id_equipo=p.id_equipol
            OR e.id_equipo=p.id_equipoV
            ORDER BY PUNTOS DESC, e.nombre DESC;');
			  
  -- aplicar el nombre del documento root. El nombre por defecto es ROWSET      		  
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'clasificatoria');
  
  -- Aplicar la cabecera con el nombre clasificacion
  DBMS_XMLGEN.setRowTag(qryCtx, 'clasificacion');
  
  -- Obtener los resultados
  result := DBMS_XMLGEN.getXML(qryCtx);
  INSERT INTO temp_clob_tab VALUES(result);
  
  --cerrar context
  DBMS_XMLGEN.closeContext(qryCtx);
END;
