/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Dueno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author ketro
 */
public class TDueno {
private ResultSet resultado; 
private Connection con;
private TEquipo tequi;

    public TDueno(Connection con, TEquipo tequi) {
        this.con = con;
        this.tequi = tequi;
    }

   
    
    

    public int buscarDuenoPK(String nombre) throws Exception {
        String sentencia = "SELECT NOMBRE,TELEFONO, NACIONALIDAD,ID_EQUIPO FROM DUENO WHERE NOMBRE=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(nombre));

        resultado = ps.executeQuery();
        if (resultado.next()) {
            // Como por un atributo tipo objeto?
          return resultado.getInt("id_dueno");
        } else {
            return 0;
        }
    }
    
     public Dueno buscarDueno(String nombre) throws Exception {
        String sentencia = "SELECT ID_DUENO, NOMBRE,TELEFONO, NACIONALIDAD,ID_EQUIPO FROM DUENO WHERE NOMBRE=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(nombre));

        resultado = ps.executeQuery();
        if (resultado.next()) {
           Dueno due;
            due = new Dueno();
            due.setId(Integer.parseInt(resultado.getString("ID_DUENO")));
            due.setNombreCompleto(resultado.getString("NOMBRE"));
            due.setTelefono(resultado.getString("TELEFONO"));
            due.setNacionalidad(resultado.getString("NACIONALIDAD"));
            due.setEquipo(tequi.buscarEquipoById(Integer.parseInt(resultado.getString("ID_EQUIPO"))));
            
            return due;
        } else {
            return null;
        }
    }

    public void insertarDueno(Dueno due) throws Exception {

        String sentencia = "INSERT INTO DUENO(NOMBRE, TELEFONO,NACIONALIDAD, ID_EQUIPO)VALUES (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, due.getNombreCompleto());
        ps.setString(2, due.getTelefono());
        ps.setString(3, due.getNacionalidad()); 
        ps.setString(4, String.valueOf(due.getEquipo().getId_equipo()));
        

        int resultado = ps.executeUpdate();
        ps.close();
        if (resultado != 1) {
            throw new Exception("El numero de filas insertadas no es uno");
        }
        
    }

    public void modificarDueno(Dueno due) throws Exception {
        // No podemos modificar el nombre del dueño
        String sentencia = "UPDATE DUENO SET nombre=?,TELEFONO=?, NACIONALIDAD=? ,ID_EQUIPO=?"
                + "WHERE ID_DUENO = ?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, due.getNombreCompleto());
        ps.setString(2, due.getTelefono());
        ps.setString(3, due.getNacionalidad());
        ps.setString(4, String.valueOf(due.getEquipo().getId_equipo()));
        ps.setString(5,String.valueOf( due.getId()));
      
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1) {
            throw new Exception("El numero de filas actualizadas no es uno");
        }

    }

    public void borrarDueno(String nombreCompleto) throws Exception {

        {
            String sentencia = "DELETE FROM DUENO WHERE NOMBRE =?";
            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1, nombreCompleto);
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1) {
                throw new Exception("Error a la hora de eliminar el Dueno");
            }
        }
    }
 
}
