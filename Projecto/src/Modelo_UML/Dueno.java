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
     private Equipo equipo;
    

    public Dueno() {
    }

    public Dueno(Equipo equipo) {
        this.equipo = equipo;
    }

    
    public Dueno(Equipo equipo, String nombreCompleto, String nacionalidad, String telefono,int id) {
        super(nombreCompleto, nacionalidad, telefono,id);
        this.equipo = equipo;
    }
    

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    
  
    
}