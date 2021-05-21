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
    private Equipo nombreEqui;
  
    public Dueno() {
    }

    public Dueno(String nombre, String telefono, String nacionalidad, Equipo nombreEqui) {
        super(nombre, telefono, nacionalidad);
        this.nombreEqui = nombreEqui;
    }

    public Equipo getNombreEqui() {
        return nombreEqui;
    }

    public void setNombreEqui(Equipo nombreEqui) {
        this.nombreEqui = nombreEqui;
    }

    
    
}
