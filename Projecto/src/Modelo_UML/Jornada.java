/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

import java.time.LocalDate;

/**
 *
 * @author ketro
 */
public class Jornada {
    private LocalDate fecha ;

    public Jornada() {
    }

    public Jornada(LocalDate fecha) {
   
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
    
}
