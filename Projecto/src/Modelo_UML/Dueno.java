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

    public Dueno(Equipo equipo, String nombre,  String nacionalidad,String telefono) {
        super(nombre, telefono, nacionalidad);
        this.equipo = equipo;
    }

    public Equipo getId_equipo() {
        return equipo;
    }

    public void setId_equipo(Equipo equipo) {
        this.equipo = equipo;
    }

   
    
    
}
