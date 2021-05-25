package projecto;

import Modelo_BBDD.*;
import Modelo_UML.Administrador;
import Modelo_UML.Asistente;
import Modelo_UML.Dueno;
import Modelo_UML.Entrenador;
import Modelo_UML.Equipo;
import Modelo_UML.Jornada;
import Modelo_UML.Jugador;
import Modelo_UML.Partido;
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
import Views.Entrenadores.VInsertarEntrenador;
import Views.Jugadores.VInsertarJugadores;
import Views.Perfiles.VInsertarUsuario;
import Views.equipos.VInsertarEquipo;

//import Views.Vprincipal.Tipo;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.*;
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
    private static Partido part;

    // Creación de las Variables de las Ventanas
    private static VentanaLogin vl;
    private static Vprincipal vp;

    // Ventanas Equipo
    private static VInsertarEquipo vie;
    private static VModificarEquipo vme;
    private static VEliminarEquipo vee;
    private static VConsultarEquipo vce;

    // Ventanas Jugadores
    private static VInsertarJugadores vij;
    private static VModificarJugadores vmj;
    private static VEliminarJugadores vej;
    private static VConsultarJugadores vcj;

    // Ventanas Entrenadore
    private static VInsertarEntrenador vien;
    private static VModificarEntrenadores vmen;
    private static VEliminarEntrenadores veen;
    private static VConsultarEntrenador vcen;

    // Ventanas Dueno
    private static VInsertarDueno vid;
    private static VModificarDueno vmd;
    private static VEliminarDueno ved;
    private static VConsultarDueno vcd;

    // Ventanas Asistente
    private static VInsertarAsistente via;
    private static VModificarAsistente vma;
    private static VEliminarAsistente vea;
    private static VConsultarAsistente vca;

    // Ventanas Usuarios
    private static VInsertarUsuario viu;
    private static VModificarUsuario vmu;
    private static VEliminarUsuario veu;
    private static VConsultarUsuario vcu;

    // Otras Variables 
    private static String nombre;
    private static ArrayList<Equipo> aListaEquipo;
    private static Equipo equipoPK;

    public static void main(String[] args) {
        try {
            bd = new BaseDatos();
            con = bd.conectar();

            tadm = new TAdministrador(con);
            tusu = new TUsuario(con);
            tequi = new TEquipo(con);
            tent = new TEntrenador(con, tequi);
            tasis = new TAsistente(con, tent);
            tdue = new TDueno(con, tequi);
            tjorn = new TJornada(con);
            tjuga = new TJugador(con, tequi);
            tpart = new TPartido(con, tequi, tjorn);

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
                    nombre = usu.getNombreCompleto();
                    llamarPrincipal(Rol.USUARIO, nombre);
                }
            } else {
                nombre = adm.getNombreCompleto();
                llamarPrincipal(Rol.ADMINISTRADOR, nombre);
            }
        } catch (Exception gnr) {
            System.out.println(gnr.getClass() + gnr.getMessage() + " Error al iniciar la sesion");
        }
    }

    public static void llamarPrincipal(Rol rol, String nombre) {
        vl.dispose();
        vp = new Vprincipal(rol, nombre);
        vp.setVisible(true);
    }

    public static void cerrarSesion() {
        vp.dispose();
        vl = new VentanaLogin();
        vl.setVisible(true);
    }

    public static ArrayList <Equipo> llenarComboBox() throws Exception {
        aListaEquipo = new ArrayList();
        aListaEquipo = tequi.cogerEquipos();
        
        return aListaEquipo;
        
    }
    //public static void usuConsultaUltimoJornada(){
//busqueda en la   base de datos, de manera ordenada por la jornada mas reciente
    //}
    //public static void consultaClasificaciones(){}

// Asistente
    public static Asistente buscarAsistente(String nombre) throws Exception {
        asis = tasis.buscarAsistente(nombre);
        return asis;
    }

    public static void insertarAsistente(String nombre, String sueldo, String telefono, String nacionalidad,Entrenador entrenador) throws Exception {
        asis = new Asistente();
        asis.setNombreCompleto(nombre);
        asis.setSueldo(sueldo);
        asis.setTelefono(telefono);
        asis.setNacionalidad(nacionalidad);
        asis.setEntrenador(entrenador);
        
        tasis.insertarAsistente(asis);
    }

    public static void modificarAsistente(Asistente asistente) throws Exception {
        tasis.modificarAsistente(asistente);

    }

    public static void borrarAsistente(int id_asistente) throws Exception {
        tasis.borrarasistente(id_asistente);
    }

    // Dueño
    public static Dueno buscarDueno(String nombre) throws Exception {
        due = tdue.buscarDueno(nombre);
        return due;
    }

    public static void insertarDueno(String nombre, String telefono ,String nacionalidad, Equipo equi) throws Exception {        
        due = new Dueno();
        due.setNombreCompleto(nombre);
        due.setTelefono(telefono);
        due.setNacionalidad(nacionalidad);
        due.setEquipo(equi);
        
        tdue.insertarDueno(due);
    }

    public static void borrarDueno(String nombreCompleto) throws Exception {
        tdue.borrarDueno(nombreCompleto);
    }

    public static void modificarDueno(Dueno duenoM) throws Exception {
       
        tdue.modificarDueno(duenoM);
    }

    // Entrenador
    public static Entrenador buscarEntrenador(String nombre) throws Exception {
        ent = tent.buscarEntrenador(nombre);
        return ent;
    }

    public static void insertarEntrenador(String nombre, int sueldo, String telefono, String nacionalidad, Equipo equipo) throws Exception {
        ent = new Entrenador();
        ent.setNombreCompleto(nombre);
        ent.setSueldo(telefono);
        ent.setTelefono(telefono);
        ent.setNacionalidad(nacionalidad);
        ent.setEqui(equi);
        
        tent.insertarEntrenador(ent);
    }

    public static void borrarEntrenador(int id_entrenador) throws Exception {
        tent.borrarEntrenador(id_entrenador);
    }

    public static void modificarEntrenador() throws Exception {
        tent.modificarEntrenador(ent);
    }

    // Equipo

    public static Equipo buscarEquipoPKID(int id) throws Exception {
        Equipo nuevoEquipo;
        nuevoEquipo = tequi.buscarEquipoById(id);   
        return nuevoEquipo;
    }
    public static void buscarEquipoPK(String nombre) throws Exception {
        equipoPK = tequi.buscarEquipoByNombre(nombre);      
    }
    public static Equipo buscarEquipo(String nombre) throws Exception {
        equi = tequi.buscarEquipoByNombre(nombre);
        return equi;
    }

    public static void insertarEquipo(String nombre, String escudo) throws Exception {
        equi = new Equipo(nombre, escudo);
        tequi.insertarEquipo(equi);
    }

    public static void modificarEquipo(Equipo equipoM) throws Exception {
        tequi.modificarEquipo(equipoM);

    }

    public static void borrarEquipo(String nombre) throws Exception {
        tequi.borrarEquipo(nombre);
    }

    //Jornada
    public static Jornada buscarJornada(int id_jornada) throws Exception {
        jor = tjorn.buscarJornada(id_jornada);
        return jor;
    }

    public static void insertarJornada() throws Exception {
        tjorn.insertarJornada(jor);
    }

    public static void modificarJornada() throws Exception {
        tjorn.modificarJornada(jor);

    }

    public static void borrarJornada(int id_jornada) throws Exception {
        tjorn.borrarJornada(id_jornada);
    }

    // Jugador
    public static Jugador buscarJugador(String nombre) throws Exception {
        juga=new Jugador();
        juga = tjuga.buscarJugador(nombre);
        return juga;
    }

    public static void insertarJugador(String nombre, int sueldo,
            String nickname, String telefono, String nacionalidad,
            String rol, Equipo equipo) throws Exception {
        juga= new Jugador();
        juga.setNombreCompleto(nombre);
        juga.setSueldo(String.valueOf(sueldo));
        juga.setNickname(nickname);
        juga.setTelefono(telefono);
        juga.setNacionalidad(nacionalidad);
        juga.setRol(rol);
        juga.setEquipo(equipo);
        
        tjuga.insertarJugador(juga);
    }

    public static void modificarJugador(Jugador jug) throws Exception {
        tjuga.modificarJugador(jug);

    }

    public static void borrarJugador(int id_jugador) throws Exception {
        tjuga.borrarJugador(id_jugador);
    }


    public static Usuario buscarUsuario(String nombre) throws Exception {
        usu = tusu.buscarUsuario(nombre);
        return usu;
    }
    
    // Usuario
    public static Usuario buscarUsuario(String correo,String contrasena) throws Exception {
        usu = tusu.consultarUsu(correo,contrasena);

        return usu;
    }

    public static void insertarUsuario(String nombreCompleto, String correo, String clave) throws Exception {
        usu = new Usuario(nombreCompleto,correo,clave);
        tusu.insertarUsuario(usu);
    }
    public static void modificarUsuario() throws Exception{
     tusu.modificarUsuario(usu);
    }
    public static void borrarUsuario(int id_usuario) throws Exception{
     tusu.borrarUsuario(id_usuario);
    }

// Partido 
    public static Partido buscarPartido(int id_partido) throws Exception {
        part = tpart.buscarPartido(id_partido);
        return part;
    }

    public static void insertarPartido() throws Exception {
        tpart.insertarPartido(part);
    }

    public static void modificarPartido() throws Exception {
        tpart.modificarPartido(part);

    }

    public static void borrarPartido(int id_partido) throws Exception {
        tpart.borrarPartido(id_partido);
    }

    //Abrir Ventanas
    public static void abrirInsertarEquipo() {
        vie = new VInsertarEquipo();
        vie.setVisible(true);
    }

    public static void abrirInsertarJugador() throws Exception {
        vij = new VInsertarJugadores();
        vij.setVisible(true);
    }

    public static void abrirInsertarEntrenador() throws Exception {
        vien = new VInsertarEntrenador();
        vien.setVisible(true);
    }

    public static void abrirInsertarAsistente() {
        via = new VInsertarAsistente();
        via.setVisible(true);
    }

   /* public static void abrirInsertarDueno() throws Exception {
*/
    public static void abrirInsertarDueno() throws Exception {


        vid = new VInsertarDueno();
        vid.setVisible(true);
     }
    public static void abrirInsertarUsuario() {
        viu = new VInsertarUsuario();
        viu.setVisible(true);
    }

    public static void abrirModificarAsistente() {
        vma = new VModificarAsistente();
        vma.setVisible(true);
    }

    public static void abrirModificarDueño() throws Exception {
        vmd = new VModificarDueno();
        vmd.setVisible(true);
    }

    public static void abrirModificarUsuario() {
        vmu = new VModificarUsuario();
        vmu.setVisible(true);
    }

    public static void abrirModificarEntrenador() throws Exception {        
        vmen = new VModificarEntrenadores();
        vmen.setVisible(true);
    }

    public static void abrirModificarJugador() throws Exception {
        vmj = new VModificarJugadores();
        vmj.setVisible(true);
    }

    public static void abrirModificarEquipos() {
        vme = new VModificarEquipo();
        vme.setVisible(true);
    }

    /*public static String getNombreEquipos(int x) {
              
    }*/

    public static void abrirEliminarEquipo()   {
        vee = new VEliminarEquipo();
        vee.setVisible(true);
    }
    
    public static void abrirEliminarJugador() {
        
        vej = new VEliminarJugadores();
        vej.setVisible(true);
    }

    public static void abrirEliminarEntrenador() {

        veen = new VEliminarEntrenadores();
        veen.setVisible(true);
    }

    public static void abrirEliminarAsistente() {

        vea = new VEliminarAsistente();
        vea.setVisible(true);
    }

    public static void abrirEliminarDueno() {
        ved = new VEliminarDueno();
        ved.setVisible(true);
    }

    public static void abrirEliminarUsuario() {

        veu = new VEliminarUsuario();
        veu.setVisible(true);
    }

    public static void abrirConsultarUsuario() {
        vcu = new VConsultarUsuario();
        vcu.setVisible(true);
    }

    public static void abrirConsultarDueno()throws Exception {
        vcd = new VConsultarDueno();
        vcd.setVisible(true);
    }

    public static void abrirConsultarAsistente() {
        vca = new VConsultarAsistente();
        vca.setVisible(true);
    }

    public static void abrirConsultarEntrenador() {
        vcen = new VConsultarEntrenador();
        vcen.setVisible(true);
    }

    public static void abrirConsultarJugadores() throws Exception{
        vcj = new VConsultarJugadores();
        vcj.setVisible(true);
    }

    public static void abrirConsultarEquipo()  {
        vce = new VConsultarEquipo();
        vce.setVisible(true);
    }

    public static void cerrarVentana(JFrame aThis) {
        aThis.dispose();
    }

    public enum Rol {
        USUARIO, ADMINISTRADOR
    }

}
