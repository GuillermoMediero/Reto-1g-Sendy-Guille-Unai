/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

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
            usu.setCorreo(resultado.getString("correo"));
            usu.setClave(resultado.getString("contrasena"));
            
            return usu;
        }
        return null;
    }

    public Usuario consultarUsu(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
