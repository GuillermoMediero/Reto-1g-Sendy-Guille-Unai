/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

/**
 *clase usuario del programa
 * @author ketro
 */
public class Usuario extends Perfil{
    
    /**
     *clase de usuaro para los perfiles del programa
     */
    public Usuario() {
    }

    /**
     * Constructor para el usuario completp
     * @param id identificador del usuario
     * @param nombreCompleto nombre completo del usuario
     * @param correo correo del usuario
     * @param clave contraseña del usuario
     */
    public Usuario(int id, String nombreCompleto, String correo, String clave) {
        super(id, nombreCompleto, correo, clave);
    }

    /**
     *
     * @param correo correo del usuario
     * @param clave contraseña del usuario
     */
    public Usuario(String correo, String clave) {
        super(correo, clave);
    }

    /**
     *
     * @param nombreCompleto nombre completo del usuario
     * @param correo correo del usuario
     * @param clave contraseña del usuario
     */
    public Usuario(String nombreCompleto, String correo, String clave) {
        super(nombreCompleto, correo, clave);
    }

  
    
    
    
}
