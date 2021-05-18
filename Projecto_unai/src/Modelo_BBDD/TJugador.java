/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Jugador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ketro
 */
public class TJugador {
    private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static ResultSet resultado;
    private static Jugador j;
    
    public static void insertatarEntrenador(Jugador ju) throws SQLException {
        BaseDatos.conectar();
        plantilla = "INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME,TELEFONO,NACIONALIDAD,ROL,ID_EQUIPO) VALUES (?,?,?,?,?,?,?); ";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,ju.getNombre());
        sentenciaPre.setString(2,ju.getSueldo());
        sentenciaPre.setString(3,ju.getNickname());
        sentenciaPre.setString(4,ju.getTelefono());
        sentenciaPre.setString(5,ju.getNacionalidad());
        sentenciaPre.setString(6,ju.getRol());
        sentenciaPre.setString(7,Integer.toString(ju.getId()));
        resultado = sentenciaPre.executeQuery();
       
    }
    public static void modificarEntrenador(Jugador ju) throws SQLException {
        BaseDatos.conectar();
        plantilla = "update JUGADOR"
                + "set TELEFONO=?,"
                + "NACIONALIDAD=?,"
                + "SUELDO=?,"
                + "ID_EQUIPO=?,"
                + "NICKNAME=?,"
                + "ROL=?"
                + "where NOMBRE=?;";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,ju.getTelefono());
        sentenciaPre.setString(2,ju.getNacionalidad());
        sentenciaPre.setString(3,ju.getSueldo());
        sentenciaPre.setString(4,Integer.toString(ju.getId()));
        sentenciaPre.setString(5,ju.getNacionalidad());
        sentenciaPre.setString(6,ju.getRol());
        sentenciaPre.setString(7,ju.getNombre());
        resultado = sentenciaPre.executeQuery();
       
    }
    public static void borrarEntrenador(Jugador ju) throws SQLException {
        BaseDatos.conectar();
        plantilla = "delete from JUGADOR"
                + "where NOMBRE=?;";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,ju.getNombre());
        resultado = sentenciaPre.executeQuery();
    }
}
