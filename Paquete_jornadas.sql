CREATE OR REPLACE PACKAGE GEST_JORNADA AS
PROCEDURE insertar_jornada(p_num_jornada number, p_fecha date);
END GEST_JORNADA;

CREATE OR REPLACE PACKAGE BODY GEST_JORNADA AS

PROCEDURE insertar_jornada(p_num_jornada number, p_fecha date)
AS
    fecha jornada.fecha%TYPE;
    existe boolean;
    jorn_repetido exception;
    ya_existe exception;
BEGIN
     declare 
        x VARCHAR2(10);
    begin
        select * into x from jornada
        where num_jornada = p_num_jornada;
        existe:=true;
    Exception
            When no_data_found then
                existe:=false;
            when too_many_rows then
                raise jorn_repetido;
    end;
    if fecha is null then
        fecha := sysdate + 7;
    else
        fecha := fecha + 7;
    end if;
    
    IF NOT existe then
    Insert into jornada (fecha) values (fecha);
     else
        raise ya_existe;
     end if;
EXCEPTION
    WHEN jorn_repetido THEN
        RAISE_APPLICATION_ERROR('-20015', 'Esta jornada esta repetido');
    WHEN ya_existe then
        RAISE_APPLICATION_ERROR('-20016', 'Ya existe esta jornada');
END insertar_jornada;
END GEST_JORNADA;