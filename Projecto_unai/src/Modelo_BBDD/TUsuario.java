/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Administrador;
import Modelo_UML.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ketro
 */
public class TUsuario {
private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static ResultSet resultado;
    private static Usuario a;
    
    public static Boolean Conectarusu(String correo,String contrasena) throws SQLException {
         
        BaseDatos.conectar();
            
        plantilla = "select * from usuario where CORREO = ? AND CONTRASENA= ?";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,correo);
        sentenciaPre.setString(2,contrasena);
        resultado = sentenciaPre.executeQuery();
        if (resultado.next())
        {      
            BaseDatos.desconectar();
            return true;
        }
         else
         {      
            BaseDatos.desconectar(); 
             return false;   
         }
        
    }
}
