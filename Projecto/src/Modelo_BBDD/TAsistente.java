
package Modelo_BBDD;

import Modelo_UML.Asistente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ketro
 */
public class TAsistente {

    private Connection con;
    private TEntrenador tent;

    public TAsistente(Connection con, TEntrenador tent) {
        this.con = con;
        this.tent = tent;
    }
    
   
    // Buscar porque no me funciona la busqueda *nullpointerException
    public Asistente buscarAsistente(String nombre) throws Exception {
        String sentencia = "SELECT NOMBRE, SUELDO, TELEFONO, NACIONALIDAD FROM ASISTENTE WHERE NOMBRE=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(nombre));

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            Asistente asis;
            asis = new Asistente();
            asis.setNombre(resultado.getString("NOMBRE"));
            asis.setSueldo(resultado.getString("SUELDO"));
            asis.setTelefono(resultado.getString("TELEFONO"));
            asis.setNacionalidad(resultado.getString("NACIONALIDAD"));

            return asis;
        } else {
            return null;
        }
    }
     public int buscarAsistentePK(String nombre) throws Exception {
        String sentencia = "SELECT NOMBRE, SUELDO, TELEFONO, NACIONALIDAD FROM ASISTENTE WHERE nombre=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(nombre));

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            return resultado.getInt("id_asistente");
        } else {
            return 0;
        }
    }

    public void insertarAsistente(Asistente asis) throws Exception {

        String sentencia = "INSERT INTO ASISTENTE(NOMBRE, SUELDO, TELEFONO, NACIONALIDAD)VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, asis.getNombre());
        ps.setString(2, String.valueOf(asis.getSueldo()));
        ps.setString(3, asis.getTelefono());
        ps.setString(4, asis.getNacionalidad());

        int resultado = ps.executeUpdate();
        ps.close();
        if (resultado != 1) {
            throw new Exception("El numero de filas insertadas no es uno");
        }
        // Puede retornar asistente por si quiero ensenar un mensaje "xxxxx insertado"
    }

    public void modificarAsistente(Asistente asis) throws Exception {
        // No podemos modificar el nombre del asistente
        String sentencia = "UPDATE ASISTENTE SET SUELDO=?, TELEFONO=?, NACIONALIDAD=? "
                + "WHERE NOMBRE = ?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, asis.getSueldo());
        ps.setString(2, asis.getTelefono());
        ps.setString(2, asis.getNacionalidad());
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1) {
            throw new Exception("El numero de filas actualizadas no es uno");
        }

    }

    public void borrarasistente(int id_asistente) throws Exception {

        {
            String sentencia = "DELETE FROM ASISTENTE WHERE NOMBRE =?";
            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1, String.valueOf(id_asistente));
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1) {
                throw new Exception("Error a la hora de eliminar el Asistente");
            }
        }
    }
}
