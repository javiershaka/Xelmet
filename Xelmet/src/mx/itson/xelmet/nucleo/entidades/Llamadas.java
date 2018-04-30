
package mx.itson.xelmet.nucleo.entidades;

import java.util.Date;

public class Llamadas {
    
    private int idLlamada;
    private String receptor;
    private TipoLlamada tipollamada;
    private int duracionMinutos;
    private double costo;
    private Date fecha;

    /**
     * @return the idLlamada
     */
    public int getIdLlamada() {
        return idLlamada;
    }

    /**
     * @param idLlamada the idLlamada to set
     */
    public void setIdLlamada(int idLlamada) {
        this.idLlamada = idLlamada;
    }

    /**
     * @return the receptor
     */
    public String getReceptor() {
        return receptor;
    }

    /**
     * @param receptor the receptor to set
     */
    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    /**
     * @return the tipollamada
     */
    public TipoLlamada getTipollamada() {
        return tipollamada;
    }

    /**
     * @param tipollamada the tipollamada to set
     */
    public void setTipollamada(TipoLlamada tipollamada) {
        this.tipollamada = tipollamada;
    }

    /**
     * @return the duracionMinutos
     */
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    /**
     * @param duracionMinutos the duracionMinutos to set
     */
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    /**
     * @return the costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
     
}
