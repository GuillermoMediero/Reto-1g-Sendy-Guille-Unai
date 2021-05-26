/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

import java.time.LocalDate;

/**
 *clase jornada del proyecto
 * @author ketro
 */
public class Jornada {
    private int num_jornada;
    private LocalDate fecha ;

    /**
     *constructor de jornada sin ningun dato
     */
    public Jornada() {
    }

    /**
     *constriuctor de jornada con el dato de la fechoa
     * @param fecha dia de la jornada
     */
    public Jornada(LocalDate fecha) {
   
        this.fecha = fecha;
    }

    /**
     *
     * @param num_jornada
     * @param fecha
     */
    public Jornada(int num_jornada, LocalDate fecha) {
        this.num_jornada = num_jornada;
        this.fecha = fecha;
    }

    /**
     * obtencioncion dela fecha de la jornada
     * @return dia de la jornada
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * implementacion dela fecha de la jornada
     * @param fecha dia de la jornada
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @return
     */
    public int getNum_jornada() {
        return num_jornada;
    }

    /**
     *
     * @param num_jornada
     */
    public void setNum_jornada(int num_jornada) {
        this.num_jornada = num_jornada;
    }
    
    
    
}
