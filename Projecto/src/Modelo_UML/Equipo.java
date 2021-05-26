/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

/**
 *clase equipo del programa
 * @author ketro
 */
public class Equipo {
    private String nombre;
    private String escudo;
    private int id_equipo;
    
    /**
     * constructor del eqipo con todos los datos
     * @param nombre nombre del equipo
     * @param escudo escudo del equipo
     */
    public Equipo(String nombre, String escudo) {
        this.nombre = nombre;
        this.escudo = escudo;
    }   

    /**
     * constructor del eqipo sin ningun dato
     */
    public Equipo() {
    }

    /**
     * obtencioncion del nombre del equipo
     * @return nombre del equipo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * implementacion del nombre del equipo
     * @param nombre nombre del equipo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * obtencioncion del escudo del equipo
     * @return escudo del equipo
     */
    public String getEscudo() {
        return escudo;
    }

    /**
     * implementacion del escudo del equipo
     * @param escudo escudo del equipo
     */
    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    /**
     * implementacion del codigo del equipo
     * @return codigo del equipo
     */
    public int getId_equipo() {
        return id_equipo;
    }

    /**
     * implementacion del codigo del equipo
     * @param id_equipo codigo del equipo
     */
    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }
    
    
}
