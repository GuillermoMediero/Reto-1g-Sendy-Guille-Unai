/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

/**
 *
 * @author ketro
 */
public class Dueno extends Integrante{
    private Equipo id_equipo;
  
    public Dueno() {
    }

    public Dueno(Equipo id_equipo) {
        this.id_equipo = id_equipo;
    }

    public Dueno(Equipo id_equipo, int id, String nombre, String telefono, String nacionalidad) {
        super(id, nombre, telefono, nacionalidad);
        this.id_equipo = id_equipo;
    }

    public Dueno(String nombre, String telefono, String nacionalidad, int equipo) {
       
    }

    

    public Equipo getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Equipo id_equipo) {
        this.id_equipo = id_equipo;
    }
    
    
}
