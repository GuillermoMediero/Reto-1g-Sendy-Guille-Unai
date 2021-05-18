/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Entrenador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ketro
 */
public class TEntrenador {
    
    private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static ResultSet resultado;
    private static Entrenador en;
    
    public static void insertatarEntrenador(Entrenador ent) throws SQLException {
        BaseDatos.conectar();
        plantilla = "INSERT INTO ENTRENADOR(NOMBRE,SUELDO,TELEFONO,NACIONALIDAD,ID_EQUIPO) VALUES (?,?,?,?,?); ";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,ent.getNombre());
        sentenciaPre.setString(2,ent.getSueldo());
        sentenciaPre.setString(3,ent.getTelefono());
        sentenciaPre.setString(4,ent.getNacionalidad());
        sentenciaPre.setString(5,Integer.toString(ent.getId()));
        resultado = sentenciaPre.executeQuery();
       
    }
    public static void modificarEntrenador(Entrenador ent) throws SQLException {
        BaseDatos.conectar();
        plantilla = "update ENTRENADOR"
                + "set telefono=?,"
                + "NACIONALIDAD=?,"
                + "SUELDO=?,"
                + "ID_EQUIPO=?"
                + "where NOMBRE=?;";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,ent.getTelefono());
        sentenciaPre.setString(2,ent.getNacionalidad());
        sentenciaPre.setString(3,ent.getSueldo());
        sentenciaPre.setString(4,Integer.toString(ent.getId()));
        sentenciaPre.setString(5,ent.getNombre());
        resultado = sentenciaPre.executeQuery();
       
    }
    public static void borrarEntrenador(Entrenador ent) throws SQLException {
        BaseDatos.conectar();
        plantilla = "delete from ENTRENADOR"
                + "where NOMBRE=?;";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,ent.getNombre());
        resultado = sentenciaPre.executeQuery();
       
    }
}
