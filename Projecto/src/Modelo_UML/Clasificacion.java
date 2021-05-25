/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

/**
 *
 * @author 1GDAW12
 */
public class Clasificacion {
    private String Nombre;
    private int partidos_jugados;
    private int victorias;
    private int derrotas;
    private int puntos; 

    public Clasificacion(String Nombre, int partidos_jugados, int victorias, int derrotas, int puntos) {
        this.Nombre = Nombre;
        this.partidos_jugados = partidos_jugados;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.puntos = puntos;
    }

    public Clasificacion() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPartidos_jugados() {
        return partidos_jugados;
    }

    public void setPartidos_jugados(int partidos_jugados) {
        this.partidos_jugados = partidos_jugados;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
            
}
