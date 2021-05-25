
package Modelo_BBDD;

import Modelo_UML.Partido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ketro
 */
public class TPartido {
private Connection con;
private TEquipo tequi;
private TJornada tjor;
private ArrayList<Partido> aListaJornada;

    public TPartido(Connection con, TEquipo tequi, TJornada tjor) {
        this.con = con;
        this.tequi = tequi;
        this.tjor = tjor;
    }
  
    public Partido buscarPartido(int id_partido) throws Exception {
        String sentencia = "SELECT HORA, RESULTADOL, RESULTADOV, NUM_JORNADA, ID_EQUIPOL, ID_EQUIPOV FROM PARTIDO"
                + " WHERE ID_PARTIDO=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1,String.valueOf( id_partido));

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            Partido part;
            part = new Partido();
            part.setHora(resultado.getString(String.valueOf("HORA")));
            part.setResultado_l(resultado.getString(String.valueOf("RESULTADOL")));
            part.setResultado_v(resultado.getString(String.valueOf("RESULTADOV")));
            part.setJornada(tjor.buscarJornada(("NUM_JORNADA")));
            part.setEquipol(tequi.buscarEquipoById(Integer.getInteger("ID_EQUIPOL")));
            part.setEquipov(tequi.buscarEquipoById((Integer.getInteger("ID_EQUIPOV"))));                                
            
            return part;
        } else {
            return null;
        }
    }

    public void insertarPartido(Partido part) throws Exception {

        String sentencia = "INSERT INTO PARTIDO(HORA, RESULTADOL,RESULTADOV, NUM_JORNADA, "
                + "ID_EQUIPOL, ID_EQUIPOV)"
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sentencia);
         ps.setString(1, part.getHora());
        ps.setString(2, part.getResultado_l());
        ps.setString(3, part.getResultado_v());
        ps.setString(4, String.valueOf(part.getJornada()));
        ps.setString(5, String.valueOf(part.getEquipol()));
        ps.setString(6, String.valueOf(part.getEquipov()));

        int resultado = ps.executeUpdate();
        ps.close();
        if (resultado != 1) {
            throw new Exception("El numero de filas insertadas no es uno");
        }

    }

    public void modificarPartido(Partido part) throws Exception {
        // No podemos modificar el nombre del asistente
        String sentencia = "UPDATE PARTIDO SET HORA=?,RESULTADOL=?, RESULTADOV=? ,NUM_JORNADAS=?,"
                + " ID_EQUIPOL=?, ID_EQUIPOV=?"
                + "WHERE ID_PARTIDO= ?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, part.getHora());
        ps.setString(2, part.getResultado_l());
        ps.setString(3, part.getResultado_v());
        ps.setString(4, String.valueOf(part.getJornada()));
        ps.setString(5, String.valueOf(part.getEquipol()));
        ps.setString(6, String.valueOf(part.getEquipov()));
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1) {
            throw new Exception("El numero de filas actualizadas no es uno");
        }

    }

    public void borrarPartido(int id_partido) throws Exception {

        {
            String sentencia = "DELETE FROM PARTIDO WHERE ID_PARTIDO =?";
            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1, String.valueOf(id_partido));
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1) {
                throw new Exception("Error a la hora de eliminar el Partido");
            }
        }
    }
    
        public ArrayList<Partido> consultarPartidos() throws Exception {
         aListaJornada= new ArrayList();
        String sentencia = "SELECT HORA, RESULTADOL, RESULTADOV, NUM_JORNADA, ID_EQUIPOL, ID_EQUIPOV FROM PARTIDO";
        PreparedStatement ps = con.prepareStatement(sentencia);
  
        ResultSet resultado = ps.executeQuery();
        
        while (resultado.next()) {
            Partido part = new Partido();
            part.setHora(resultado.getString(String.valueOf("HORA")));
            part.setResultado_l(resultado.getString(String.valueOf("RESULTADOL")));
            part.setResultado_v(resultado.getString(String.valueOf("RESULTADOV")));
            part.setJornada(tjor.buscarJornada(("NUM_JORNADA")));
            part.setEquipol(tequi.buscarEquipoById(Integer.getInteger("ID_EQUIPOL")));
            part.setEquipov(tequi.buscarEquipoById((Integer.getInteger("ID_EQUIPOV"))));                                
            
            aListaJornada.add(part);
        }
        if (  aListaJornada.isEmpty())
           throw new Exception("no se ha encontrado ningun equipo");
        return  aListaJornada;
        }
    }

