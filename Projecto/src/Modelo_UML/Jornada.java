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
    private int id_jornada ;
    private LocalDate fecha ;

    public Jornada() {
    }

    public Jornada(int id_jornada, LocalDate fecha) {
        this.id_jornada = id_jornada;
        this.fecha = fecha;
    }

    public int getId_jornada() {
        return id_jornada;
    }

    public void setId_jornada(int id_jornada) {
        this.id_jornada = id_jornada;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
    
}
