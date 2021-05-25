/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;


import Modelo_UML.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ketro
 */
public class TJugador {

    private Connection con;
    private TEquipo tequi;

    public TJugador(Connection con, TEquipo tequi) {
        this.con = con;
        this.tequi = tequi;
    }

     public Jugador buscarJugadorPK(int id_jugador) throws Exception {
        String sentencia = "SELECT NOMBRE, SUELDO, NICKNAME, TELEFONO, NACIONALIDAD,ROL, ID_EQUIPO FROM JUGADOR"
                + " WHERE id_jugador=?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(id_jugador));

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            Jugador juga;
            juga = new Jugador();
            juga.setNombreCompleto(resultado.getString("NOMBRE"));
            juga.setSueldo(resultado.getString("SUELDO"));
            juga.setNickname(resultado.getString("NICKNAME"));
            juga.setTelefono(resultado.getString("TELEFONO"));
            juga.setNacionalidad(resultado.getString("NACIONALIDAD"));
            juga.setRol(resultado.getString("ROL"));
            juga.setEquipo(tequi.buscarEquipoById(juga.getEquipo().getId_equipo()));
            juga.setId(Integer.parseInt(resultado.getString("ID_JUGADOR")));
            return juga;
        } else {
            return null;
        }
    }
      

     public Jugador buscarJugador(String nombre) throws Exception {
        String sentencia = "SELECT NOMBRE, SUELDO, NICKNAME, TELEFONO, NACIONALIDAD, ROL, ID_EQUIPO FROM JUGADOR"
                + " WHERE NOMBRE = ?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, String.valueOf(nombre));

        ResultSet resultado = ps.executeQuery();
        if (resultado.next()) {
            Jugador juga;
            juga = new Jugador();
            juga.setNombreCompleto(resultado.getString("NOMBRE"));
            juga.setSueldo(resultado.getString("SUELDO"));
            juga.setNickname(resultado.getString("NICKNAME"));
            juga.setTelefono(resultado.getString("TELEFONO"));
            juga.setNacionalidad(resultado.getString("NACIONALIDAD"));
            juga.setRol(resultado.getString("ROL"));
            juga.setEquipo(tequi.buscarEquipoById(Integer.parseInt(resultado.getString("ID_EQUIPO"))));
            juga.setId(Integer.parseInt(resultado.getString("ID")));
             
           
            return juga;
        } else {
            return null;
        }
    }

    public void insertarJugador(Jugador juga) throws Exception {

        String sentencia = "INSERT INTO JUGADOR(NOMBRE,SUELDO,NICKNAME, TELEFONO, NACIONALIDAD, ROL, ID_EQUIPO)"
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, juga.getNombreCompleto());
        ps.setString(2, String.valueOf(juga.getSueldo()));
        ps.setString(3, juga.getNickname());
        ps.setString(4, juga.getTelefono());
        ps.setString(5, juga.getNacionalidad());
        ps.setString(6, juga.getRol());
        ps.setString(7, String.valueOf(juga.getEquipo().getId_equipo()));
        

        int resultado = ps.executeUpdate();
        ps.close();
        if (resultado != 1) {
            throw new Exception("El numero de filas insertadas no es uno");
        }

    }

    public void modificarJugador(Jugador juga) throws Exception {
        // No podemos modificar el nombre del asistente
        String sentencia = "UPDATE JUGADOR SET NOMBRE=?, SUELDO=?, NICKNAME=?,TELEFONO=?, NACIONALIDAD=? ,ROL=?, ID_EQUIPO=?"
                + "WHERE ID_JUGADOR = ?";
        PreparedStatement ps = con.prepareStatement(sentencia);
        ps.setString(1, juga.getNombreCompleto());
        ps.setString(2, juga.getSueldo());
        ps.setString(3, juga.getNickname());
        ps.setString(4, juga.getTelefono());
        ps.setString(5, juga.getNacionalidad());
        ps.setString(6, juga.getRol());
        ps.setString(7,String.valueOf(juga.getEquipo().getId_equipo()));
        ps.setString(7, String.valueOf(juga.getId()));
        int n = ps.executeUpdate();
        ps.close();
        if (n != 1) {
            throw new Exception("El numero de filas actualizadas no es uno");
        }

    }

    public void borrarJugador(int id_jugador) throws Exception {

        {
            String sentencia = "DELETE FROM JUGADOR WHERE ID_JUGADOR =?";
            PreparedStatement ps = con.prepareStatement(sentencia);
            ps.setString(1, String.valueOf(id_jugador));
            int n = ps.executeUpdate();
            ps.close();
            if (n != 1) {
                throw new Exception("Error a la hora de eliminar el Jugador");
            }
        }
    }

}
