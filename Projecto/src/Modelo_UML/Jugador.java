/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_UML;

/**
 * clase jugador del proyecto
 * @author ketro
 */
public class Jugador extends Integrante{
    private String rol;
    private String sueldo;
    private String nickname;
    private Equipo equipo;

    /**
     *constructor de jugador sin ningun dato
     */
    public Jugador() {
    }

    /**
     *constructor de jornada con los datos del jugador
     * @param rol rol del jugador
     * @param sueldo sueldo del jugador
     * @param nickname nombre de pila del jugador
     * @param equipo nombre del equipo
     */
    public Jugador(String rol, String sueldo, String nickname, Equipo equipo) {
        this.rol = rol;
        this.sueldo = sueldo;
        this.nickname = nickname;
        this.equipo = equipo;
    }

    /**
     * obtencioncion del rol del jugador
     * @return rol del jugador
     */
    public String getRol() {
        return rol;
    }

    /**
     * implementacion del rol del jugador
     * @param rol rol del jugador
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * obtencioncion del sueldo del jugador
     * @return sueldo del jugador
     */
    public String getSueldo() {
        return sueldo;
    }

    /**
     * implementacion del sueldo del jugador
     * @param sueldo sueldo del jugador
     */
    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * obtencioncion del sueldo del jugador
     * @return nombre de pila del jugador
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * implementacion del nombre de pila del jugador
     * @param nickname nombre de pila del jugador
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * obtencioncion del nombre del equipo del jugador
     * @return nombre del equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * implementacion del nombre del equipo del jugador
     * @param equipo nombre del equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
}
