/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Entrenador;
import Modelo_UML.Equipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ketro
 */
public class TEquipo {
    private static PreparedStatement sentenciaPre;
    private static String plantilla;
    private static ResultSet resultado;
    
    private static Equipo q;
    public static void insertatarEquipo(Equipo eq) throws SQLException {
        BaseDatos.conectar();
        plantilla = "INSERT INTO EQUIPO(NOMBRE,ESCUDO) VALUES (?,?); ";
        sentenciaPre =BaseDatos.getCon().prepareStatement(plantilla);
        sentenciaPre.setString(1,eq.getNombre());
        sentenciaPre.setString(2,eq.getEscudo());
        resultado = sentenciaPre.executeQuery();
       
    }
    
}
