/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

/**
 * clase clasificacion del programa
 * @author 1GDAW12
 */
public class Clasificacion {
    private String Nombre;
    private int partidos_jugados;
    private int victorias;
    private int derrotas;
    private int puntos; 

    /**
     * Construccion de la clasificacion con todos los datos
     * @param Nombre Nombre del equipo
     * @param partidos_jugados Cantidad de partidos jugados
     * @param victorias Cantidad de partidos ganados
     * @param derrotas  Cantidad de partidos ganados
     * @param puntos puntos actuales de la liga
     */
    public Clasificacion(String Nombre, int partidos_jugados, int victorias, int derrotas, int puntos) {
        this.Nombre = Nombre;
        this.partidos_jugados = partidos_jugados;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.puntos = puntos;
    }

    /**
     *Construccion de la clasificacion sin ningun dato
     */
    public Clasificacion() {

    }

    /**
     * Ontencion del nombre del equipo
     * @return Nombre  Nombre del equipo 
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * implementacion del nombre del equipo   
     * @param Nombre Nombre del equipo
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * inplementa la Cantidad de partidos jugados
     * @return Cantidad de partidos jugados del equipo
     */
    public int getPartidos_jugados() {
        return partidos_jugados;
    }

    /** 
     * inplementa la Cantidad de partidos jugados
     * @param partidos_jugados Cantidad de partidos jugados
     */
    public void setPartidos_jugados(int partidos_jugados) {
        this.partidos_jugados = partidos_jugados;
    }

    /**
     * obtiene la Cantidad de partidos ganados
     * @return  Cantidad de partidos ganados
     */
    public int getVictorias() {
        return victorias;
    }

    /**
     * inplementa la Cantidad de partidos ganados
     * @param victorias  Cantidad de partidos ganados
     */
    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    /**
     * obtiene la Cantidad de partidos perdidos
     * @return  Cantidad de partidos ganados
     */
    public int getDerrotas() {
        return derrotas;
    }

    /**
     *inplementa la Cantidad de partidos perdidos
     * @param derrotas  Cantidad de partidos perdidos
     */
    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    /**
     *obtiene los puntos actuales de la liga de un equipo
     * @return puntos actuales de la liga
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * inplementa los puntos actuales de la liga de un equipo
     * @param puntos puntos actuales de la liga
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
            
}
