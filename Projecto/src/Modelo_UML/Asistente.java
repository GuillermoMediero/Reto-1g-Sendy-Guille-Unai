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
    private Entrenador entrenador;

    public Asistente() {
    }

    public Asistente(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Asistente(Entrenador entrenador, String sueldo, Equipo equi) {
        super(sueldo, equi);
        this.entrenador = entrenador;
    }

    public Asistente(Entrenador entrenador, String sueldo, Equipo equi, String nombreCompleto, String nacionalidad, String telefono, int id) {
        super(sueldo, equi, nombreCompleto, nacionalidad, telefono, id);
        this.entrenador = entrenador;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}
