/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Dueno;
import Modelo_UML.Entrenador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ketro
 */
public class TDueno {
    private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static ResultSet resultado;
    private static Dueno D;
    public static void insertatardueno(Dueno du) throws SQLException {
        BaseDatos.conectar();
        plantilla = "INSERT INTO Dueno(NOMBRE,TELEFONO,NACIONALIDAD,ID_EQUIPO) VALUES (?,?,?,?,?); ";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,du.getNombre());
        sentenciaPre.setString(2,du.getTelefono());
        sentenciaPre.setString(3,du.getNacionalidad());
        sentenciaPre.setString(4,Integer.toString(du.getId()));
        resultado = sentenciaPre.executeQuery();
       
    }
    public static void modificarDueno(Dueno du) throws SQLException {
        BaseDatos.conectar();
        plantilla = "update Dueno"
                + "set telefono=?,"
                + "NACIONALIDAD=?,"
                + "SUELDO=?,"
                + "ID_EQUIPO=?"
                + "where NOMBRE=?;";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,du.getTelefono());
        sentenciaPre.setString(2,du.getNacionalidad());
        sentenciaPre.setString(4,Integer.toString(du.getId()));
        sentenciaPre.setString(5,du.getNombre());
        resultado = sentenciaPre.executeQuery();
       
    }
    public static void borrarDueno(Dueno du) throws SQLException {
        BaseDatos.conectar();
        plantilla = "delete from Dueno"
                + "where NOMBRE=?;";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,du.getNombre());
        resultado = sentenciaPre.executeQuery();
    
}
}
