CREATE or replace TABLE temp_clas_table(RETURN CLOB)

DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
  result CLOB;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
              'select * from clasificacion');
			  
  -- aplicar el nombre del documento root. El nombre por defecto es ROWSET      		  
  DBMS_XMLGEN.setRowSetTag(qryCtx, 'Clasificacion');
  
  -- Aplicar la cabecera con el nombre clasificacion
  DBMS_XMLGEN.setRowTag(qryCtx, 'Posicion');
  
  -- Obtener los resultados
  result := DBMS_XMLGEN.getXML(qryCtx);
  INSERT INTO temp_clob_table VALUES(result);
  
  --cerrar context
  DBMS_XMLGEN.closeContext(qryCtx);
END;
