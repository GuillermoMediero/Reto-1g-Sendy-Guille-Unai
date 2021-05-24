/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ketro
 */
public class TEquipo {
    private Connection con;
    ArrayList<Equipo> aListEquipo;
    
    public TEquipo(Connection con) {
        this.con = con;
    }
    public Equipo buscarEquipoByNombre(String nombre) throws Exception {
        String sentencia = "SELECT * FROM EQUIPO WHERE NOMBRE=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(nombre));

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            Equipo equi;
            equi = new Equipo();
            equi.setNombre(resultado.getString("NOMBRE"));
            equi.setEscudo(resultado.getString("ESCUDO"));
            equi.setId_equipo(resultado.getInt("ID_EQUIPO"));
            return equi;
        } else {
            return null;
        }
    }
    public Equipo buscarEquipoById(int id_equipo) throws Exception {
        String sentencia = "SELECT * FROM EQUIPO WHERE id_equipo=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(id_equipo));

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            Equipo equi;
            equi = new Equipo();
            equi.setNombre(resultado.getString("NOMBRE"));
            equi.setEscudo(resultado.getString("ESCUDO"));
            equi.setId_equipo(resultado.getInt("ID_EQUIPO"));
            return equi;
        } else {
            return null;
        }
    }
   

    public void insertarEquipo(Equipo equi) throws Exception {

        String sentencia = "INSERT INTO EQUIPO(NOMBRE,ESCUDO) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, equi.getNombre());
        ps.setString(2, equi.getEscudo());
   

        int resultado = ps.executeUpdate();
        ps.close();
        if (resultado != 1) {
            throw new Exception("El numero de filas insertadas no es uno");
        }

    }

    public void modificarEquipo(Equipo equi) throws Exception {
        // No podemos modificar el nombre del equipo
        String sentencia = "UPDATE EQUIPO SET SUELDO=?,ESCUDO=? WHERE NOMBRE = ?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, equi.getNombre());
        ps.setString(2, equi.getEscudo());
       
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1) {
            throw new Exception("El numero de filas actualizadas no es uno");
        }

    }

    public void borrarEquipo(String nombre) throws Exception {

        {
            String sentencia = "DELETE FROM EQUIPO WHERE nombre =?";
            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1, String.valueOf(nombre));
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1) {
                throw new Exception("Error a la hora de eliminar el Equipo");
            }
        }
    }
    
    public  ArrayList<Equipo> cogerEquipos() throws Exception{
        aListEquipo= new ArrayList();
        String sentencia = "SELECT NOMBRE FROM EQUIPO";
        PreparedStatement ps = con.prepareStatement(sentencia);
 
        ResultSet resultado = ps.executeQuery();
        
        while (resultado.next()) {
            Equipo equi;
            equi = new Equipo();
            equi.setNombre(resultado.getString("NOMBRE"));
     
           aListEquipo.add(equi);
        } 
        if ( aListEquipo.isEmpty())
           throw new Exception("no se ha encontrado ningun equipo");
        return aListEquipo;   
        
    }
    
}
