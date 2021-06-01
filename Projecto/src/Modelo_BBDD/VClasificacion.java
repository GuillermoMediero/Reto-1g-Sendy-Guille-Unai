/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import Modelo_UML.Clasificacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 1GDAW12
 */
public class VClasificacion {
    private ArrayList<Clasificacion> aListaClasi;
    private Connection con;

    public VClasificacion(Connection con) {
        this.con = con;
    }

    public Clasificacion consultarClasificacion() throws Exception {
        String sentencia = " SELECT NOMBRE,PARTIDOS_JUGADOS,VICTORIAS,DERROTAS,PUNTOS FROM CLASIFICACION";
        PreparedStatement ps = con.prepareStatement(sentencia);

        ResultSet resultado = ps.executeQuery();
        
        while (resultado.next()) {
            Clasificacion clasi = new Clasificacion();
            clasi.setNombre(resultado.getString("NOMBRE"));
            clasi.setPartidos_jugados(Integer.parseInt(resultado.getString("PARTIDOS_JUGADOS")));
            clasi.setVictorias(Integer.parseInt(resultado.getString("VICTORIAS")));
            clasi.setDerrotas(Integer.parseInt(resultado.getString("DERROTAS")));
            clasi.setPuntos(Integer.parseInt(resultado.getString("PUNTOS")));
            return clasi;
        } 
            return null;
        
    }
    public  ArrayList<Clasificacion> consultarTodasClasificacion() throws Exception{
         aListaClasi= new ArrayList();
        String sentencia = "SELECT * FROM CLASIFICACION";
        PreparedStatement ps = con.prepareStatement(sentencia);
 
        ResultSet resultado = ps.executeQuery();
        
        while (resultado.next()) {
          Clasificacion clasi = new Clasificacion();
            clasi.setNombre(resultado.getString("NOMBRE"));
            clasi.setPartidos_jugados(Integer.parseInt(resultado.getString("PARTIDOS_JUGADOS")));
            clasi.setVictorias(Integer.parseInt(resultado.getString("VICTORIAS")));
            clasi.setDerrotas(Integer.parseInt(resultado.getString("DERROTAS")));
            clasi.setPuntos(Integer.parseInt(resultado.getString("PUNTOS")));
     
            aListaClasi.add(clasi);
        } 
        if (  aListaClasi.isEmpty())
           throw new Exception("no se ha encontrado ningun equipo");
        return  aListaClasi;   
        
    }
    
}
