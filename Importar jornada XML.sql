--CREATE TABLE temp_clob_tab(Return CLOB);

DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
  result CLOB;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
              'SELECT *
              FROM JORNADA');
			  
   -- aplicar el nombre del documento root. El nombre por defecto es ROWSET     		  
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'jornadas');
  
  -- Aplicar la cabecera con el nombre jornada
  DBMS_XMLGEN.setRowTag(qryCtx, 'jornada');
  
  -- Obtener los resultados
  result := DBMS_XMLGEN.getXML(qryCtx);
  INSERT INTO temp_clob_tab VALUES(result);
  
  --cerrar context
  DBMS_XMLGEN.closeContext(qryCtx);
END;

