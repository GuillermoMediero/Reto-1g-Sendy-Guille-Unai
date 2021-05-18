/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Dueno;
import Modelo_UML.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ketro
 */
public class TEntrenador {
private Connection con;
    public TEntrenador(Connection con) {
     
    }
    
      public Entrenador buscarEntrenador(String nombre) throws Exception {
        String sentencia = "SELECT NOMBRE,SUELDO,TELEFONO, NACIONALIDAD,ID_EQUIPO FROM DUENO WHERE NOMBRE=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, nombre);

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
           Entrenador ent;
            ent = new Entrenador();
            ent.setNombre(resultado.getString("NOMBRE"));
            ent.setNombre(resultado.getString("SUELDO"));
            ent.setTelefono(resultado.getString("TELEFONO"));
            ent.setNacionalidad(resultado.getString("NACIONALIDAD"));
            
            return ent;
        } else {
            return null;
        }
    }

    public void insertarEntrenador(Entrenador ent) throws Exception {

        String sentencia = "INSERT INTO ENTRENADOR(NOMBRE,SUELDO, TELEFONO, NACIONALIDAD) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, ent.getNombre());
        ps.setString(2,String.valueOf(ent.getSueldo()));
        ps.setString(3, ent.getTelefono());
        ps.setString(4, ent.getNacionalidad());
        

        int resultado = ps.executeUpdate();
        ps.close();
        if (resultado != 1) {
            throw new Exception("El numero de filas insertadas no es uno");
        }
        
    }

    public void modificarEntrenador(Entrenador ent) throws Exception {
        // No podemos modificar el nombre del asistente
            String sentencia = "UPDATE ENTRENADOR SET SUELDO=?, TELEFONO=?, NACIONALIDAD=? "
                + "WHERE NOMBRE = ?";
        PreparedStatement ps = con.prepareStatement(sentencia);
         ps.setString(1, ent.getSueldo());
        ps.setString(2, ent.getTelefono());
        ps.setString(3, ent.getNacionalidad());
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1) {
            throw new Exception("El numero de filas actualizadas no es uno");
        }

    }

    public void borrarEntrenador(String nombre) throws Exception {

        {
            String sentencia = "DELETE FROM ENTRENADOR WHERE NOMBRE =?";
            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1, nombre);
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1) {
                throw new Exception("Error a la hora de eliminar el Entrenador");
            }
        }
    }
    
}
