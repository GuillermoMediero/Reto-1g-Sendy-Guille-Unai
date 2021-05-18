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
import Views.Asistentes.VInsertarAsistente;
import Views.Dueño.VInsertarDueño;
import Views.Entrenadores.VInsertarEntrenadores;
import Views.Jugadores.VInsertarJugadores;
import Views.Perfiles.VInsertarUsuario;
import Views.equipos.VInsertarEquipo;
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
    private static VInsertarEquipo vie;
    private static VInsertarJugadores vij;
    private static VInsertarEntrenadores vien;
    private static VInsertarDueño vid;
    private static VInsertarAsistente via;
    private static VInsertarUsuario viu;

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
        vie = new VInsertarEquipo();
        vie.setVisible(true);
    }

    public static void cancelarInsertarEquipo() {
        vie.dispose();
    }

    public static void abrirInsertarJugador() {
        vij = new VInsertarJugadores();
        vij.setVisible(true);
    }

    public static void abrirInsertarEntrenador() {
        vien = new VInsertarEntrenadores();
        vien.setVisible(true);
    }

    public static void abrirInsertarAsistente() {
        via = new VInsertarAsistente();
        via.setVisible(true);
    }

    public static void abrirInsertarDueño() {
        vid = new VInsertarDueño();
        vid.setVisible(true);
    }
    public enum Rol {
        USUARIO, ADMINISTRADOR
    }

    public static void cancelarInsertarJugador() {
        vij.dispose();
    }

    public static void cancelarInsertarEntrenador() {
        vien.dispose();
    }

    public static void cancelarInsertarDueño() {
        vid.dispose();
    }

    public static void cancelarInsertarAsistente() {
        via.dispose();
    }

    public static void cancelarInsertarUsuarios() {
       viu.dispose();
    }
}
