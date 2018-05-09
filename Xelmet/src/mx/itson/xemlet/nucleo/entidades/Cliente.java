package mx.itson.xemlet.nucleo.entidades;

import com.sun.scenario.effect.InvertMask;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


/**
 * 
 * @author javiershaka
 */
@Entity
public class Cliente {

    private int id;
    private String nombre;
    private String numeroTelefonico;
    private String domicilio;
    private Paquete paquete;
    private List<Llamada> llamadas;
    
    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the numeroTelefonico
     */
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    /**
     * @param numeroTelefonico the numeroTelefonico to set
     */
    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the paquete
     */
  
    @OneToOne
    @JoinColumn(name = "paquete")
    public Paquete getPaquete() {
        return paquete;
    }

    /**
     * @param paquete the paquete to set
     */
    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    /**
     * @return the llamadas
     */
     @OneToMany
    
     @JoinColumn(name = "idReferencial")
            
   
  
     
    public List<Llamada> getLlamadas() {
        return llamadas;
    }

    /**
     * @param llamadas the llamadas to set
     */
    public void setLlamadas(List<Llamada> llamadas) {
        this.llamadas = llamadas;
    }

    /**
     * @return the listaLlamada
     */
  

    
    
    
}
