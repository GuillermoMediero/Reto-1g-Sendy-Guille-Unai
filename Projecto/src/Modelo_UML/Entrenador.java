/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

/**
 *clase entrenador del programa
 * @author ketro
 */
public class Entrenador extends Integrante{
    private String sueldo;
    private Equipo equi;

    /**
     *contructor entrenador sin ningun dato
     */
    public Entrenador() {
    }

    /**
     *contructor entrenador con los datos del sueldo y el nombre del equipo
     * @param sueldo sueldo del asistente
     * @param equi nombre del equipo
     */
    public Entrenador(String sueldo, Equipo equi) {
        this.sueldo = sueldo;
        this.equi = equi;
    }

    /**
     *contructor entrenador con todos los datos 
     * @param sueldo sueldo del entrenador
     * @param equi nombre del equipo
     * @param nombreCompleto nombre completo del entrenador
     * @param nacionalidad pais del entrenador
     * @param telefono telefono del entrenador
     * @param id codigo del entrenador
     */
    public Entrenador(String sueldo, Equipo equi, String nombreCompleto, String nacionalidad, String telefono, int id) {
        super(nombreCompleto, nacionalidad, telefono, id);
        this.sueldo = sueldo;
        this.equi = equi;
    }

    /**
     * obtencion del sueldo del entrenador
     * @return sueldo del entrenador
     */
    public String getSueldo() {
        return sueldo;
    }

    /**
     * implementacion del sueldo del entrenador
     * @param sueldo sueldo del entrenador
     */
    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * obtencion de los datos del equipo
     * @return nombre del equipo 
     */
    public Equipo getEqui() {
        return equi;
    }

    /**
     * implementacion de los datos del equipo
     * @param equi nombre del equipo
     */
    public void setEqui(Equipo equi) {
        this.equi = equi;
    }

    
    
}
