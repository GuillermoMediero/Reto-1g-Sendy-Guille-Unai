CREATE TABLE temp_clas_tab(RETURN CLOB)

DECLARE
  qryCtx DBMS_XMLGEN.ctxHandle;
  result CLOB;
BEGIN
  qryCtx := DBMS_XMLGEN.newContext(
              '');
			  
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
