
package Modelo_UML;

/**
 * clase  partido del proyecto
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

    /**
     *constructor del partido sin ningun dato
     */
    public Partido() {
    }

    /**
     *constructor del partido con todos los datos
     * @param id_partido codigo del partido
     * @param hora hora del partido
     * @param resultado_l resultado del equipo local del partido
     * @param resultado_v resultado del equipo visitante del partido
     * @param equipol  equipo local del partido
     * @param equipov equipo visitante del partido
     * @param jornada numero de la jornada del partido
     */
    public Partido(String id_partido, String hora, String resultado_l, String resultado_v, Equipo equipol, Equipo equipov, Jornada jornada) {
        this.id_partido = id_partido;
        this.hora = hora;
        this.resultado_l = resultado_l;
        this.resultado_v = resultado_v;
        this.equipol = equipol;
        this.equipov = equipov;
        this.jornada = jornada;
    }
    

    /**
     * obtencion del codigo del partido
     * @return codigo del partido
     */
    public String getId_partido() {
        return id_partido;
    }

    /**
     * implementacion del codigo del partido
     * @param id_partido codigo del partido
     */
    public void setId_partido(String id_partido) {
        this.id_partido = id_partido;
    }

    /**
     * obtencion de la hora del partido
     * @return hora del partido
     */
    public String getHora() {
        return hora;
    }

    /**
     * implementacion de la hora del partido
     * @param hora hora del partido
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * obtencion del la resultado del equipo local del partido
     * @return resultado del equipo local del partido
     */
    public String getResultado_l() {
        return resultado_l;
    }

    /**
     *implementacion del la resultado del equipo local del partido
     * @param resultado_l resultado del equipo local del partido
     */
    public void setResultado_l(String resultado_l) {
        this.resultado_l = resultado_l;
    }

    /**
     * obtencion del la resultado del equipo local del partido
     * @return resultado del equipo visitante del partido
     */
    public String getResultado_v() {
        return resultado_v;
    }

    /**
     *implementacion del la resultado del equipo local del partido
     * @param resultado_v resultado del equipo visitante del partido
     */
    public void setResultado_v(String resultado_v) {
        this.resultado_v = resultado_v;
    }

    /**
     * obtencion del  equipo local del partido
     * @return resultado del equipo visitante del partido
     */
    public Equipo getEquipol() {
        return equipol;
    }

    /**
     * implementacion del equipo local del partido
     * @param equipol  equipo local del partido
     */
    public void setEquipol(Equipo equipol) {
        this.equipol = equipol;
    }

    /**
     * obtencion del equipo visitante del partido
     * @return equipo visitante del partido
     */
    public Equipo getEquipov() {
        return equipov;
    }

    /**
     * implementacion del equipo visitante del partido
     * @param equipov equipo visitante del partido
     */
    public void setEquipov(Equipo equipov) {
        this.equipov = equipov;
    }

    /**
     * obtencion del numero de la jornada del partido
     * @return numero de la jornada del partido
     */
    public Jornada getJornada() {
        return jornada;
    }

    /**
     *implementacion del numero de la jornada del partido
     * @param jornada numero de la jornada del partido
     */
    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    
    
    
}
