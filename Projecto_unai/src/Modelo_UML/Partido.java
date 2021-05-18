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
public class Partido {
    private String id_partido;
    private String hora;
    private String resultado_l;
    private String resultado_v;
    private Equipo equipol ;
    private Equipo equipov ;
    private Jornada jornada ;

    public Partido() {
    }

    public String getId_partido() {
        return id_partido;
    }

    public void setId_partido(String id_partido) {
        this.id_partido = id_partido;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getResultado_l() {
        return resultado_l;
    }

    public void setResultado_l(String resultado_l) {
        this.resultado_l = resultado_l;
    }

    public String getResultado_v() {
        return resultado_v;
    }

    public void setResultado_v(String resultado_v) {
        this.resultado_v = resultado_v;
    }

    public Equipo getEquipol() {
        return equipol;
    }

    public void setEquipol(Equipo equipol) {
        this.equipol = equipol;
    }

    public Equipo getEquipov() {
        return equipov;
    }

    public void setEquipov(Equipo equipov) {
        this.equipov = equipov;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    
    
    
}
