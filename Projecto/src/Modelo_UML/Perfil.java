/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

/**
 * Constructor del perfil del proyecto
 * @author ketro
 */
public abstract class Perfil {
    private int id;
    private String nombreCompleto  ;
    private String correo  ;
    private String clave  ;
    
    /**
     *constructor del perfil sin ningun dato
     */
    public Perfil() {
    }

    /**
     *constructor del perfil con los datos del correo y contrasña
     * @param correo correo del perfil
     * @param clave contraseña del perfio
     */
    public Perfil(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    /**
     * constructor del perfil con todos los parametros sin el identificador
     * @param nombreCompleto nombre completo del perfil
     * @param correo correo del perfil
     * @param clave contraseña del perfio
     */
    public Perfil(String nombreCompleto, String correo, String clave) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.clave = clave;
    }

    /**
     *
     * @param id identificador del perfil
     * @param nombreCompleto nombre completo del perfil
     * @param correo correo del perfil
     * @param clave contraseña del perfio
     */
    public Perfil(int id, String nombreCompleto, String correo, String clave) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.clave = clave;
    }

    /**
     * obtencion del identificador del perfil
     * @return identificador del perfil
     */
    public int getId() {
        return id;
    }

    /**
     *inplementacion del identificador del perfil
     * @param id identificador del perfil
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * obtencion del nombre completo del perfil
     * @return nombre completo del perfil
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     *inplementacion del nombre completo del perfil
     * @param nombreCompleto nombre completo del perfil
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }    

    /**
     * obtencion del correo del perfil
     * @return correo del perfil
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *inplementacion del correo del perfil
     * @param correo correo del perfil
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * obtencion de la contraseña del perfio
     * @return contraseña del perfio
     */
    public String getClave() {
        return clave;
    }

    /** 
     *inplementacion de la contraseña del perfio
     * @param clave contraseña del perfio
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
}