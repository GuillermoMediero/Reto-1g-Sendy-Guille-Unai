/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;
import static javax.swing.JOptionPane.*;
import Modelo_BBDD.*;
import Modelo_UML.Administrador;
import Modelo_UML.Usuario;
import Views.*;
//import Views.Vprincipal.Tipo;
import java.sql.Connection;
/**
 *
 * @author ketro
 */
public class Controlador {
    // Variables de las Tablas de la base de datos
    private static BaseDatos bd;
    private static TUsuario tusu;
    private static TAdministrador tadm;
    private static Connection con;

    // Variables de las UML
    private static Administrador adm;
    private static Usuario usu;
   
    // Variables de las Ventanas
    private static VentanaLogin vl;
    private static Vprincipal vp;

    public static void main(String[] args) {
        try {
            bd = new BaseDatos();
            con = bd.conectar();
            
            tadm = new TAdministrador(con);
            tusu = new TUsuario(con);
            
            
            //u = new TUsuario(bd.getCon());
            vl = new VentanaLogin();
            vl.setVisible(true);
            
        } catch (Exception e) {
            bd.desconectar();
            System.out.println("Error " + e.getMessage());
        }
    }

    public static void inicioSesion(String correo, String clave) {
        try {
           // showMessageDialog(null, correo + "" + clave);

            // Llamar el metodo de la tabla adm para comprobar el adm    
            adm = tadm.consultarAdm(correo, clave);

            if (adm == null) {
                
                // Si no hay adm con ese correo y clave comprobamos si hay usuario   
                usu = tusu.consultarUsu(correo, clave);

                if (usu == null) {
                    // Si usuario no existe, error.
                    throw new Exception("Error, El usuario no existe");
                } else {
                    llamarPrincipal(Rol.USUARIO);
                }
            } else {
                llamarPrincipal(Rol.ADMINISTRADOR);
            }
        } catch (Exception gnr) {
            System.out.println(gnr.getClass() + gnr.getMessage() + " Error al iniciar la sesion");
        }
    }

    public static void llamarPrincipal(Rol rol) {
        vl.dispose();
        vp = new Vprincipal(rol);
        vp.setVisible(true);
    }

    public static void cerrarSesion() {
        vp.dispose();
        vl = new VentanaLogin();
        vl.setVisible(true);
    }
    //public static void usuConsultaUltimoPartido(){
        
    //}
    
    //public static void consultaClasificaciones(){}
    
   /* public static void alterarDatos(Tipo tipoCampo){
        switch(tipoCampo){
            case EQUIPOS:
                 insertarEquipos();
                 modificarEquipos();
                 borrarEquipos();
                 consultarEquipos();
                break;
            case INTEGRANTES:
                insertarIntegrantes();
                modificarIIntegrantes();
                borrarIntegrantes();
                consultarIntegrantes();
                break;
            default:
                insertarPerfilUsuario();
                modificarPerfilUsuario();
                borrarPerfilUsuario();
                consultarPerfilUsuario();
                break;
                
        }
    }
*/  

    public static void abrirInsertarEquipo() {
        ie = new InsertarEquipo();
        ie.setVisible(true);
    }

    public static void cancelarInsertarEquipo() {
        ie.dispose();
    }
    public enum Rol {
        USUARIO, ADMINISTRADOR
    }
}
