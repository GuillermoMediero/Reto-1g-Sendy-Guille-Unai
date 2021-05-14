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
public class Jugador extends Integrante{
    private String rol;
    private String sueldo;
    private String nickname;
    private Equipo equipo;

    public Jugador() {
    }

    public Jugador(String rol, String sueldo, String nickname, Equipo equipo) {
        this.rol = rol;
        this.sueldo = sueldo;
        this.nickname = nickname;
        this.equipo = equipo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    
    
}
