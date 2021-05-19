/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;


import Modelo_UML.Jornada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

/**
 *
 * @author ketro
 */
public class TJornada {
  private Connection con;

    public TJornada(Connection con) {

    }

    public Jornada buscarJornada(LocalDate fecha) throws Exception {
        String sentencia = "SELECT FECHA FROM JORNADA"
                + " WHERE FECHA=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, fecha.toString());

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            Jornada jor;
            jor = new Jornada();
            jor.setFecha(resultado.getString(FECHA));
      
     
            return jor;
        } else {
            return null;
        }
    }

    public void insertarJornada(Jornada jor) throws Exception {

        String sentencia = "INSERT INTO JORNADA(FECHA)"
                + "VALUES (?)";
        PreparedStatement ps = con.prepareStatement(sentencia);
       ps.setString(1, String.valueOf(jor.getFecha()));
   

        int resultado = ps.executeUpdate();
        ps.close();
        if (resultado != 1) {
            throw new Exception("El numero de filas insertadas no es uno");
        }

    }
    //no sé que poner
    public void modificarJornada(Jornada jor) throws Exception {
        // No podemos modificar el nombre del equipo
        String sentencia = "UPDATE JORNADA SET FECHA=?"
                + "WHERE NOMBRE = ?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(jor.getFecha()));
       
       
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1) {
            throw new Exception("El numero de filas actualizadas no es uno");
        }

    }

    public void borrarJornada(String nombre) throws Exception {

        {
            String sentencia = "DELETE FROM JORNADA WHERE NOMBRE =?";
            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1, nombre);
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1) {
                throw new Exception("Error a la hora de eliminar el Jornada");
            }
        }
    }
    
    
}
