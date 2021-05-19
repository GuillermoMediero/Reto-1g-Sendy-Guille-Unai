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
public class Equipo {
    private String nombre;
    private String escudo;
    private Partido id_part;

    public Equipo(String nombre, String escudo) {
        this.nombre = nombre;
        this.escudo = escudo;
    }

    public Equipo(String nombre, String escudo, Partido id_part) {
        this.nombre = nombre;
        this.escudo = escudo;
        this.id_part = id_part;
    }

    public Partido getId_part() {
        return id_part;
    }

    public void setId_part(Partido id_part) {
        this.id_part = id_part;
    }
    

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }
    
    
}
