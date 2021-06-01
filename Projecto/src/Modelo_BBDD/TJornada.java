package Modelo_BBDD;

import Modelo_UML.Jornada;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ketro
 */
public class TJornada {

    private Connection con;

    public TJornada(Connection con) {

    }

    public Jornada buscarJornada(int id_jornada) throws Exception {
        String sentencia = "SELECT FECHA FROM JORNADA"
                + " WHERE FECHA=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(id_jornada));

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            Jornada jor;
            jor = new Jornada();
            jor.setFecha(resultado.getDate("FECHA").toLocalDate());

            return jor;
        } else {
            return null;
        }
    }

    public void insertarJornada(Jornada jor) throws Exception {

        String sentencia = "INSERT INTO JORNADA(FECHA)"
                + "VALUES (?)";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, jor.getFecha().toString());

        int resultado = ps.executeUpdate();
        ps.close();
        if (resultado != 1) {
            throw new Exception("El numero de filas insertadas no es uno");
        }

    }

    // Hay que comprobar
    public void modificarJornada(Jornada jor) throws Exception {
        // No podemos modificar el nombre del equipo
        String sentencia = "UPDATE JORNADA SET FECHA=?"
                + "WHERE ID_JORNADA = ?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(Date.valueOf("FECHA"))); 
        
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1) {
            throw new Exception("El numero de filas actualizadas no es uno");
        }

    }

    public void borrarJornada(int id_jornada) throws Exception {

        {
            String sentencia = "DELETE FROM JORNADA WHERE NOMBRE =?";
            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1, String.valueOf(id_jornada));
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1) {
                throw new Exception("Error a la hora de eliminar el Jornada");
            }
        }
    }

    public Jornada buscarNumJornada(int id_jornada) throws Exception {
        String sentencia = "SELECT NUM_JORNADA FROM JORNADA"
                + " WHERE NUM_JORNADA=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(id_jornada));

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            Jornada jor;
            jor = new Jornada();
            jor.setNum_jornada(id_jornada);

            return jor;
        }
        return null;
    }
}