/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Administrador;
import Modelo_UML.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ketro
 */
public class TAdministrador {
    private String nombre;

   
private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static ResultSet resultado;
    private static Administrador a;
    
    public static Boolean Conectaradmin(String correo,String contrasena) throws SQLException {
         
        BaseDatos.conectar();
            
        plantilla = "select * from ADMINISTRADOR where CORREO = ? AND CONTRASEÑA= ?;";
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
