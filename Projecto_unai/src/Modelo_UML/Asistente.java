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
public class Asistente extends Entrenador{
    private String sueldo;

    public Asistente() {
    }

    public Asistente(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    
    
    
}
