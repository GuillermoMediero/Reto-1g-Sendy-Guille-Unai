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
public class Entrenador extends Integrante{
    private String sueldo;
    private Equipo equi;

    public Entrenador(String sueldo, Equipo equi) {
        this.sueldo = sueldo;
        this.equi = equi;
    }

    public Entrenador() {
    }
    
    
    public Entrenador(String sueldo, Equipo equi, int id, String nombre, String telefono, String nacionalidad) {
        super(id, nombre, telefono, nacionalidad);
        this.sueldo = sueldo;
        this.equi = equi;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public Equipo getEqui() {
        return equi;
    }

    public void setEqui(Equipo equi) {
        this.equi = equi;
    }

  

}
