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

    public Entrenador() {
    }

    public Entrenador(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }
    
    
}
