/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

/**
 *clase doeno del programa
 * @author ketro
 */
public class Dueno extends Integrante{
     private Equipo equipo;
    
    /**
     *contructor dueno sin ningun dato
     */
    public Dueno() {
    }

    /**
     * contructor dueno con el dato del equipo
     * @param equipo  nombre del equipo
     */
    public Dueno(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     *
     * @param equipo  nombre del equipo 
     * @param nombreCompleto nombre completo del dueno
     * @param nacionalidad pais del dueno
     * @param telefono telefono del dueno
     * @param id codigo del dueno
     */
    public Dueno(Equipo equipo, String nombreCompleto, String nacionalidad, String telefono,int id) {
        super(nombreCompleto, nacionalidad, telefono,id);
        this.equipo = equipo;
    }
    
    /**
     * obtencion de los datos del equipo
     * @return nombre del equipo 
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * implementacion de los datos del equipo
     * @param equipo  nombre del equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    
  
    
}