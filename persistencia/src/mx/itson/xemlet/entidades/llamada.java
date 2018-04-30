
package mx.itson.xemlet.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author mppme
 */
@Entity
public class llamada {
    
   private int idllamada;
   private String receptor;
   private int tipoLlamada;
   private int duracion;
   private String fecha;
   private double costo;
   
   @Id
    @GeneratedValue
    public int getId() {
        return idllamada;
    }

    public int getIdllamada() {
        return idllamada;
    }

    public void setIdllamada(int idllamada) {
        this.idllamada = idllamada;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public int getTipoLlamada() {
        return tipoLlamada;
    }

    public void setTipoLlamada(int tipoLlamada) {
        this.tipoLlamada = tipoLlamada;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
}
