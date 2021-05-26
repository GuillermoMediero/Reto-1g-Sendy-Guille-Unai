/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

/**
 * clase asistente del programa
 * @author ketro
 */
public class Asistente extends Entrenador{
    private Entrenador entrenador;

    /**
     *constructor del asistente si nnecesidad de la insercion de algun dato
     */
    public Asistente() {
    }

    /**
     * constructor del asistente con el dato del entrenador
     * @param entrenador Entrenador del equipo 
     */
    public Asistente(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    /**
     * constructor del asistente con el dato del entrenador, sueldo y equipo
     * @param entrenador Entrenador del equipo 
     * @param sueldo sueldo del asistente
     * @param equi nombre del equipo
     */
    public Asistente(Entrenador entrenador, String sueldo, Equipo equi) {
        super(sueldo, equi);
        this.entrenador = entrenador;
    }

    /**
     * constructor del asistente con todos los datos
     * @param entrenador Entrenador del equipo 
     * @param sueldo sueldo del asistente
     * @param equi nombre del equipo
     * @param nombreCompleto nombre completo del asistente
     * @param nacionalidad pais del asistente
     * @param telefono telefono del asistente
     * @param id codigo del asistente
     */ 
    public Asistente(Entrenador entrenador, String sueldo, Equipo equi, String nombreCompleto, String nacionalidad, String telefono, int id) {
        super(sueldo, equi, nombreCompleto, nacionalidad, telefono, id);
        this.entrenador = entrenador;
    }

    /**
     * obtencion de los datos del entrenados
     * @return Entrenador del equipo 
     */
    public Entrenador getEntrenador() {
        return entrenador;
    }

    /**
     * implementacion de los datos del entrenados
     * @param entrenador Entrenador del equipo 
     */
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}
