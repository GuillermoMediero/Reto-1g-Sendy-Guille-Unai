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
public abstract class Perfil {
    private int id;
    private String nombreCompleto  ;
    private String correo  ;
    private String clave  ;
    

    public Perfil() {
    }

    public Perfil(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public Perfil(String nombreCompleto, String correo, String clave) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.clave = clave;
    }

    public Perfil(int id, String nombreCompleto, String correo, String clave) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}