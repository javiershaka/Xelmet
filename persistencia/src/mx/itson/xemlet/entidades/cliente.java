
package mx.itson.xemlet.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author mppme
 */
@Entity
public class cliente {
    
    private int idcliente;
    private String numeroTelefonico;
    private String nombre;
    private String domicilio;
    private int idpaquete;
    private int idllamada;
    
     @Id
    @GeneratedValue
    public int getId() {
        return idcliente;
    }
    


    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(int idpaquete) {
        this.idpaquete = idpaquete;
    }

    public int getIdllamada() {
        return idllamada;
    }

    public void setIdllamada(int idllamada) {
        this.idllamada = idllamada;
    }
}
