/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;
import static javax.swing.JOptionPane.*;
import Modelo_BBDD.*;
import Modelo_UML.Administrador;
import Modelo_UML.Asistente;
import Modelo_UML.Usuario;
import Views.*;
import Views.Asistentes.*;
import Views.Dueño.*;
import Views.Entrenadores.*;
import Views.Jugadores.*;
import Views.Perfiles.*;
import Views.equipos.*;
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
    private static TAsistente tasis;
    private static TDueno tdue;
    private static TEntrenador tent;
    private static TEquipo tequi;
    private static TJornada tjorn;
    private static TJugador tjuga;
     private static TPartido tpart;
    

    // Variables de las UML
    private static Administrador adm;
    private static Usuario usu;

    
   
    // Variables de las Ventanas
    private static VentanaLogin vl;
    private static Vprincipal vp;
    private static VInsertarEquipo vie;

    

    private static VInsertarJugadores vij;
    private static VInsertarEntrenadores vien;
    private static VInsertarDueno vid;
    private static VInsertarAsistente via;
    private static VInsertarUsuario viu;

    private static VModificarAsistente vma;
    private static VModificarJugadores vmj;
    private static VModificarEntrenadores vmen;
    private static VModificarDueno vmd;
    private static VModificarUsuario vmu;
    private static VModificarEquipo vme;
    
    public static void main(String[] args) {
        try {
            bd = new BaseDatos();
            con = bd.conectar();
            
            tadm = new TAdministrador(con);
            tusu = new TUsuario(con);
            tasis = new TAsistente(con);
            tdue = new TDueno(con);
            tent = new TEntrenador(con);
            tequi = new TEquipo(con);
            tjorn = new TJornada(con);
            tjuga = new TJugador(con);
            tpart = new TPartido(con);
            
            
            
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
        vid = new VInsertarDueno();
        vid.setVisible(true);
    }

    public static void abrirInsertarUsuario() {
        viu = new VInsertarUsuario();
        viu.setVisible(true);
    }

    public static void cancelarModificarAsistente() {
        vma.dispose();
    }

    public static void abrirModificarAsistente() {
        vma = new VModificarAsistente();
        vma.setVisible(true);
    }

    public static void cancelarModificarDueño() {
        vmd.dispose();
    }

    public static void cancelarModificarEntrenador() {
        vmen.dispose();
    }

    public static void cancelarModificarJugador() {
        vmj.dispose();
    }

    public static void cancelarModificarUsuarios() {
       vmu.dispose();
    }

    public static void cancelarModificarEquipo() {
       vme.dispose();
    }

    public static void abrirModificarDueño() {
        vmd = new VModificarDueno();
        vmd.setVisible(true);
    }

    public static void abrirModificarUsuario() {
        vmu = new VModificarUsuario();
        vmu.setVisible(true);
    }

    public static void abrirModificarEntrenador() {
        vmen = new VModificarEntrenadores();
        vmd.setVisible(true);
    }

    public static void abrirModificarJugador() {
        vmj = new VModificarJugadores();
        vmj.setVisible(true);
    }

    public static void abrirModificarEquipos() {
        vme = new VModificarEquipo();
        vme.setVisible(true);
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
