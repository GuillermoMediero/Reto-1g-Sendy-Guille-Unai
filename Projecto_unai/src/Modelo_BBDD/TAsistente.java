/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Asistente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ketro
 */
public class TAsistente {
    private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static ResultSet resultado;
    private static Asistente a;
    
    public static void insertarasistente(Asistente as) throws SQLException {
        BaseDatos.conectar();
        plantilla = "INSERT INTO ASISTENTE(NOMBRE,TELEFONO,NACIONALIDAD,SUELDO) VALUES (?,?,?,?);";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,as.getNombre());
        sentenciaPre.setString(2,as.getTelefono());
        sentenciaPre.setString(3,as.getNacionalidad());
        sentenciaPre.setString(4,as.getSueldo());
        resultado = sentenciaPre.executeQuery();
       
    }
    public static void modificarasistente(Asistente as) throws SQLException {
        BaseDatos.conectar();
        plantilla = "update ASISTENTE"
                + "set telefono=?,"
                + "NACIONALIDAD=?,"
                + "SUELDO=?"
                + "where NOMBRE=?;";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,as.getTelefono());
        sentenciaPre.setString(2,as.getNacionalidad());
        sentenciaPre.setString(3,as.getSueldo());
        sentenciaPre.setString(4,as.getNombre());
        resultado = sentenciaPre.executeQuery();
       
    }
    public static void borrarasistente(Asistente as) throws SQLException {
        BaseDatos.conectar();
        plantilla = "delete from ASISTENTE"
                + "where NOMBRE=?;";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,as.getNombre());
        resultado = sentenciaPre.executeQuery();
       
    }
}
