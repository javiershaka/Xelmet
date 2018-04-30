
package mx.itson.xelmet.nucleo.entidades;

import java.util.List;

/**
 *
 * @author fcoav
 */
public class Cliente {
   private int idCliente;
   private String nombre;
   private String numeroTelefonico;
    private String domicilio;
    private Paquete idPaquete;
    private List <Llamadas> listaLlamada;

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
     * @return the idPaquete
     */
    public Paquete getIdPaquete() {
        return idPaquete;
    }

    /**
     * @param idPaquete the idPaquete to set
     */
    public void setIdPaquete(Paquete idPaquete) {
        this.idPaquete = idPaquete;
    }

    /**
     * @return the listaLlamada
     */
    public List <Llamadas> getListaLlamada() {
        return listaLlamada;
    }

    /**
     * @param listaLlamada the listaLlamada to set
     */
    public void setListaLlamada(List <Llamadas> listaLlamada) {
        this.listaLlamada = listaLlamada;
    }
   
   
   
    
}
