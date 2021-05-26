/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

/**
 *clase integrante del programa
 * @author ketro
 */
public class Integrante {
    private String nombreCompleto;
    private String nacionalidad;
    private String telefono;
    private int id;

    /**
     * Constructor de integrante sin ningun dato 
     */
    public Integrante() {
    }

    /**
     * Constructor de integrante con todos los dato 
     * @param nombreCompleto nombre completo del integrante
     * @param nacionalidad pais del integrante
     * @param telefono telefono del integrante
     * @param id codigo del integrante
     */
    public Integrante(String nombreCompleto, String nacionalidad, String telefono, int id) {
        this.nombreCompleto = nombreCompleto;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.id = id;
    }

    /**
     * obtencioncion del codigo del integrante
     * @return codigo del integrante
     */
    public int getId() {
        return id;
    }

    /**
     * implementacion  del codigo del integrante
     * @param id codigo del integrante
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * obtencioncion del nombre del integrante
     * @return nombre completo del integrante
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * obtencioncion del nombre del integrante
     * @param nombreCompleto nombre completo del integrante
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * obtencioncion del pais del integrante
     * @return pais del integrante
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * implementacion del pais del integrante
     * @param nacionalidad pais del integrante
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * obtencioncion del telefono del integrante
     * @return telefono del integrante
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * implementacion del telefono del integrante
     * @param telefono telefono del integrante
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

  
}
