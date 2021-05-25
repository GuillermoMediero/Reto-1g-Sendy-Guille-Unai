/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ketro
 */
public class TAdministrador {
    private Connection con;

    public TAdministrador( Connection con) {
        
        this.con = con;
    }
    
    public Administrador consultarAdm(String correo,String contrasena) throws Exception {
        String sentencia = "SELECT NOMBRE, CORREO, CONTRASENA FROM ADMINISTRADOR WHERE CORREO=? and CONTRASENA=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, correo);
        ps.setString(2, contrasena);
        
        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            
            Administrador  adm = new Administrador ();
            adm.setNombreCompleto(resultado.getString("nombre"));
            adm.setCorreo(resultado.getString("correo"));
            adm.setClave(resultado.getString("contrasena"));
            
            return adm;
        }
        return null;
    }
    
}
