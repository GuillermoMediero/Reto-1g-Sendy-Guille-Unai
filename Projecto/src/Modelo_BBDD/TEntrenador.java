/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;


import Modelo_UML.Entrenador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ketro
 */
public class TEntrenador {
private Connection con;
private TEquipo tequi;

    public TEntrenador(Connection con, TEquipo tequi) {
        this.con = con;
        this.tequi = tequi;
    }


    
      public Entrenador buscarEntrenador(String nombre) throws Exception {
        String sentencia = "SELECT NOMBRE,SUELDO,TELEFONO, NACIONALIDAD,ID_EQUIPO, ID_ENTRENADOR FROM ENTRENADOR WHERE NOMBRE=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, nombre);

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
           Entrenador ent;
            ent = new Entrenador();
            ent.setNombreCompleto(resultado.getString("NOMBRE"));
            ent.setSueldo(resultado.getString("SUELDO"));
            ent.setTelefono(resultado.getString("TELEFONO"));
            ent.setNacionalidad(resultado.getString("NACIONALIDAD"));
            ent.setEqui(tequi.buscarEquipoById(Integer.parseInt(resultado.getString("ID_EQUIPO"))));
            ent.setId(Integer.parseInt(resultado.getString("ID_ENTRENADOR")));
            
            
            return ent;
        } else {
            return null;
        }
    }
      
   /*     public Entrenador buscarEntrenadorById(int id_entrenador) throws Exception {
        String sentencia = "SELECT * FROM ENTRENADOR WHERE ID_ENTRENADORr=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(id_entrenador));

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            Entrenador ent;
            ent = new Entrenador();
            ent.setNombreCompleto(resultado.getString("NOMBRE"));
            ent.setSueldo(resultado.getString("ESCUDO"));
            ent.setEqui(resultado.getInt("ID_EQUIPO"));
            return ent;
        } else {
            return null;
        }
    }
   */

    public void insertarEntrenador(Entrenador ent) throws Exception {

        String sentencia = "INSERT INTO ENTRENADOR(NOMBRE,SUELDO, TELEFONO, NACIONALIDAD, ID_EQUIPO) VALUES (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, ent.getNombreCompleto());
        ps.setString(2,String.valueOf(ent.getSueldo()));
        ps.setString(3, ent.getTelefono());
        ps.setString(4, ent.getNacionalidad());
        ps.setString(5, String.valueOf(ent.getEqui().getId_equipo()));
         
        

        int resultado = ps.executeUpdate();
        ps.close();
        if (resultado != 1) {
            throw new Exception("El numero de filas insertadas no es uno");
        }
        
    }

    public void modificarEntrenador(Entrenador ent) throws Exception {
        // No podemos modificar el nombre del asistente
            String sentencia = "UPDATE ENTRENADOR SET NOMBRE=?, SUELDO=?, TELEFONO=?, NACIONALIDAD=?,ID_EQUIPO=? "
                + "WHERE ID_ENTRENADOR = ?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, ent.getNombreCompleto());
        ps.setString(2, ent.getSueldo());
        ps.setString(3, ent.getTelefono());
        ps.setString(4, ent.getNacionalidad());
        ps.setString(5, String.valueOf(ent.getEqui().getId_equipo()));
        ps.setString(6,String.valueOf(ent.getId()));
       
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1) {
            throw new Exception("El numero de filas actualizadas no es uno");
        }

    }

    public void borrarEntrenador(int id_entrenador) throws Exception {

        {
            String sentencia = "DELETE FROM ENTRENADOR WHERE ID_ENTRENADOR=?";
            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1, String.valueOf(id_entrenador));
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1) {
                throw new Exception("Error a la hora de eliminar el Entrenador");
            }
        }
    }
    
}
