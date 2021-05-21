/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Equipo;
import Modelo_UML.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ketro
 */

public class TUsuario {
   private Connection con;



    public TUsuario(Connection con) {
        this.con = con;
    
    }

    public Connection getCon() {
        return con;
    }

   

     public Usuario consultarUsu(String correo,String contrasena) throws Exception {
        String sentencia = "SELECT * FROM usuario where correo=? and contrasena=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, correo);
        ps.setString(2, contrasena);
        
        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {

            Usuario  usu = new Usuario();
            usu.setNombre(resultado.getString("nombre"));
            usu.setCorreo(resultado.getString("correo"));
            usu.setClave(resultado.getString("contrasena"));
            
            return usu;
        }
        return null;
    }
     public int buscarUsuarioPK(String nombre) throws Exception {
        String sentencia = "SELECT NOMBRE,ESCUDO FROM USUARIO"
                + " WHERE NOMBRE=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(nombre));

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
     
            return resultado.getInt("id_usuario");
        } else {
            return 0;
        }
    }

    public void insertarUsuario(Usuario usu) throws Exception {

        String sentencia = "INSERT INTO USUARIO(NOMBRE,CORREO,CONTRASENA) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, usu.getNombre());
        ps.setString(2, usu.getCorreo());
        ps.setString(3, usu.getClave());
   

        int resultado = ps.executeUpdate();
        ps.close();
        if (resultado != 1) {
            throw new Exception("El numero de filas insertadas no es uno");
        }

    }

    public void modificarUsuario(Usuario usu) throws Exception {
     
        String sentencia = "UPDATE USUARIO SET NOMBRE=?,CORREO=? WHERE CONTRASENA = ?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, usu.getNombre());
        ps.setString(2, usu.getCorreo());
        
       
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1) {
            throw new Exception("El numero de filas actualizadas no es uno");
        }

    }

    public void borrarUsuario(int id_usuario) throws Exception {

        {
            String sentencia = "DELETE FROM USUARIO WHERE ID_USUARIO =?";
            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1, String.valueOf(id_usuario));
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1) {
                throw new Exception("Error a la hora de eliminar el Equipo");
            }
        }
    }
    
   
}
