/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;
import Excepciones.DatoNoValido;
import static javax.swing.JOptionPane.*;
import Modelo_BBDD.*;
import Views.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ketro
 */
public class Controlador {
    private static BaseDatos bd;
    private static Vprincipal vp;
    
    private static VentanaLogin vl;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          try{
            /*bd = new BaseDatos();
            bd.conectar();*/
            
            /*tp = new TablaPersonas(bd.getCon());*/
            
            vl = new VentanaLogin();
            vl.setVisible(true);
        }
        catch(Exception e){
            bd.desconectar();
            JOptionPane.showMessageDialog(null,"Error " +  e.getMessage());
        }
    }
    
    public static void inicioSesion(String rol,String correo,String clave){
      
        if(rol.equalsIgnoreCase("administrador")){
          
          // Llamar el metodo de la tabla adm para comprobar el adm 
          //tAdm.comprobarAdm(correo, clave); 
          Vprincipal vp= new Vprincipal();
          vp.setVisible(true);
      }else{
          
          
      }
    }
    /**
     *
     * @param correo
     * @param clave
     */
    public static void iniciarSesion(String correo,String clave) throws SQLException {
      
        if(TAdministrador.Conectaradmin(correo,clave)){
          
          // Llamar el metodo de la tabla adm para comprobar el adm 
          //tAdm.comprobarAdm(correo, clave); 
          Vprincipal vp= new Vprincipal("Administrador");
          vp.setVisible(true);
         
      }else{
         if(TUsuario.Conectarusu(correo, clave)){
          
          // Llamar el metodo de la tabla adm para comprobar el adm 
          //tAdm.comprobarAdm(correo, clave); 
          Vprincipal vp= new Vprincipal("Usuario");
          vp.setVisible(true);   
         }
       else
         {
          vl = new VentanaLogin("error");
            vl.setVisible(true);   
                 }   
          
      }
      
    }
    
}
