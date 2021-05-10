-- Cabeceza paquete
create or replace package pk_crearCalendario as 
	procedure crearCalendario(); 

end pk_crearCalendario;




-- Cuerpo paquete
create or replace package body pk_crearCalendario as 
	
	--------Procedimientos Almacenados
create or replace procedure crearCalendario
    
AS

    v_error varchar2(200);

BEGIN
	select 
		case 
            when exists (select  1
						    from jugador j, equipo e 
						    where j.id_equipo=e.id_equipo
						    group by e.id_equipo, count(j.id_jugador)
						    having count(j.id_jugador)<2) 
            then RAISE_APPLICATION_ERROR(-20003,'Error, equipo con menos de 2 jugadores'); 
            else 
            	execute procedure generarPartidos();
	    	
	from dual;   

	    
	exception
	    when other then
	    v_error:='error oracle: '|| to_char(sqlcode)|| sqlerrm;
	    RAISE_APPLICATION_ERROR(-20002, v_error);
	
	end crearCalendario;

-- Procedimiento que creará todos los partidos del calendario 
-- mediante sorteo aleatorio.
-- Fuera de alcance
create or replace procedure generarPartidos();




end pk_crearCalendario;

EXECUTE calendario();