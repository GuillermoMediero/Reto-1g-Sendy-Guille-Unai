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