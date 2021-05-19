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
import Modelo_UML.Dueno;
import Modelo_UML.Entrenador;
import Modelo_UML.Equipo;
import Modelo_UML.Jornada;
import Modelo_UML.Jugador;
import Modelo_UML.Usuario;
import Views.*;

import Views.Asistentes.*;
import Views.Dueño.*;
import Views.Entrenadores.*;
import Views.Jugadores.*;
import Views.Perfiles.*;
import Views.equipos.*;

import Views.Asistentes.VInsertarAsistente;
import Views.Asistentes.VModificarAsistente;
import Views.Entrenadores.VInsertarEntrenadores;
import Views.Jugadores.VInsertarJugadores;
import Views.Perfiles.VInsertarUsuario;
import Views.equipos.VInsertarEquipo;

//import Views.Vprincipal.Tipo;
import java.sql.Connection;
import java.time.LocalDate;

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
    private static Asistente asis;
    private static Dueno due;
    private static Entrenador ent;
    private static Equipo equi;
    private static Jornada jor;
    private static Jugador juga;

    // Variables de las Ventanas
    private static VentanaLogin vl;
    private static Vprincipal vp;
    private static VInsertarEquipo vie;

    private static VInsertarJugadores vij;
    private static VInsertarEntrenadores vien;
    private static VInsertarDueno vid;
    private static VInsertarAsistente via;
    private static VModificarAsistente vma;
    private static VInsertarUsuario viu;

    private static VModificarJugadores vmj;
    private static VModificarEntrenadores vmen;
    private static VModificarDueno vmd;
    private static VModificarUsuario vmu;
    private static VModificarEquipo vme;
    
    private static VEliminarJugadores vej;
    private static VEliminarEntrenadores veen;
    private static VEliminarDueno ved;
    private static VEliminarUsuario veu;
    private static VEliminarEquipo vee;
    private static VEliminarAsistente vea;

    public static void main(String[] args) {
        try {
            bd = new BaseDatos();
            con = bd.conectar();

            tadm = new TAdministrador(bd.getCon());
            tusu = new TUsuario(bd.getCon());
            tasis = new TAsistente(bd.getCon());
            tdue = new TDueno(bd.getCon());
            tent = new TEntrenador(bd.getCon());
            tequi = new TEquipo(bd.getCon());
            tjorn = new TJornada(bd.getCon());
            tjuga = new TJugador(bd.getCon());
            tpart = new TPartido(bd.getCon());

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
    
// Asistente
    public static Asistente buscarAsistente(String nombre) throws Exception {
        asis = tasis.buscarAsistente(nombre);
        return asis;
    }

 
    public static void insertarAsistente(String nombre, String sueldo, String telefono, String nacionalidad) throws Exception {
        asis = new Asistente(nombre,sueldo,telefono,nacionalidad);
        tasis.insertarAsistente(asis);
    }
    public static void modificarAsistente(String s, String t, String nac) throws Exception {
        tasis.modificarAsistente(asis);

    }

    public static void borrarAsistente() throws Exception {
        tasis.borrarasistente(asis);
    }

    // Dueño
    public static Dueno buscarDueno(String nombre) throws Exception {
        due = tdue.buscarDueno(nombre);
        return due;
    }

    public static void insertarDueno() throws Exception {
        tdue.insertarDueno(due);
    }

    public static void borrarDueno(String nombre) throws Exception {
        tdue.borrarDueno(nombre);
    }

    public static void modificarDueno() throws Exception {
        tdue.modificarDueno(due);
    }

    // Entrenador
    public static Entrenador buscarEntrenador(String nombre) throws Exception {
        ent = tent.buscarEntrenador(nombre);
        return ent;
    }

    public static void insertarEntrenador(String nombre, int sueldo, String telefono, String nacionalidad, int equipo) throws Exception {
        ent = new Entrenador(nombre,sueldo,telefono,nacionalidad,equipo);
        tent.insertarEntrenador(ent);
    }
   

    public static void borrarEntrenador(String nombre) throws Exception {
        tent.borrarEntrenador(nombre);
    }

    public static void modificarEntrenador() throws Exception {
        tent.modificarEntrenador(ent);
    }

    // Equipo
    public static Equipo buscarEquipo(String nombre) throws Exception {
        equi = tequi.buscarEquipo(nombre);
        return equi;
    }

    public static void insertarEquipo(String nombre, String escudo) throws Exception {
        equi = new Equipo(nombre,escudo);
        tequi.insertarEquipo(equi);
    }

    public static void modificarEquipo() throws Exception {
        tequi.modificarEquipo(equi);

    }

    public static void borrarEquipo(String nombre) throws Exception {
        tequi.borrarEquipo(nombre);
    }

    //Jornada
    public static Jornada buscarJornada(LocalDate fecha) throws Exception {
        jor = tjorn.buscarJornada(fecha);
        return jor;
    }

    public static void insertarJornada() throws Exception {
        tjorn.insertarJornada(jor);
    }

    public static void modificarJornada() throws Exception {
        tjorn.modificarJornada(jor);

    }

    public static void borrarJornada(String nombre) throws Exception {
        tjorn.borrarJornada(nombre);
    }

    // Jugador
    public static Jugador buscarJugador(String nombre) throws Exception {
        juga = tjuga.buscarJugador(nombre);
        return juga;
    }
    
    public static void insertarJugador(String nombre, int sueldo, String nickname, String telefono, String nacionalidad, String rol, int equipo) throws Exception {
        tjuga.insertarJugador(juga);
    }

    public static void modificarJugador() throws Exception {
        tjuga.modificarJugador(juga);

    }
    
    public static void borrarJugador(String nombre) throws Exception {
        tjuga.borrarJugador(nombre);
    }
    
    public static Usuario buscarUsuario(String nombre) {
        usu = tusu.consultarUsu(nombre);
        return usu;
    }

    public static void insertarUsuario(String nombre, String correo, String contrasena) {
       /* usu = new Usuario(nombre,correo,contrasena);
        usu.insertarUsuario();*/
    }
    //Abrir y Cerrar Ventanas
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


    public static void abrirInsertarDueno() {

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

    public static String getNombreEquipos(int x) {
       
    }

    public static void cancelarBorrarEquipo() {
        vee.dispose();
    }

    public static void cancelarBorrarUsuarios() {
        veu.dispose();
    }

    public static void cancelarBorrarJugador() {
        vej.dispose();
    }

    public static void cancelarBorrarEntrenador() {
        veen.dispose();
    }

    public static void cancelarBorrarAsistente() {
        vea.dispose();
    }

    public static void cancelarBorrarDueño() {
       ved.dispose();
    }

    public static void abrirEliminarEquipo(String nombre) {
        
        
        vee = new VEliminarEquipo();
        vee.setVisible(true);
    }

    public static void abrirEliminarJugador(String nombre) {

        
        vej = new VEliminarJugadores();
        vej.setVisible(true);
    }

    public static void abrirEliminarEntrenador(String nombre) {
       
        
        veen = new VEliminarEntrenadores();
        veen.setVisible(true);
    }

    public static void abrirEliminarAsistente(String nombre) {
       
        
        vea = new VEliminarAsistente();
        vea.setVisible(true);
    }

    public static void abrirEliminarDueno(String nombre) {
        
        
        ved = new VEliminarDueno();
        ved.setVisible(true);
    }

    public static void abrirEliminarUsuario(String nombre) {
        
        
        veu = new VEliminarUsuario();
        veu.setVisible(true);
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

   
    public enum Rol {
        USUARIO, ADMINISTRADOR
    }

    
}
