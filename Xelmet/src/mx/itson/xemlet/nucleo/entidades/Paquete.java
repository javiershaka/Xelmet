package mx.itson.xemlet.nucleo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author javiershaka en esta clase tenemos id que es el identificador nombre
 * del maquete minutos que ofrece el paquete a celular llamadasFijas que son las
 * llamadas fijas que ofrece el paquete precio del paquete costo adicional por
 * llamada si te pasas del paquete costo adcional por minutos por si sobrepasas
 * el paquete
 */
@Entity
public class Paquete {

    private int id;
    private String nombre;
    private int minutosACelular;
    private int llamadasFijas;
    private double precio;
    private int costoAdicionalPorLlamada;
    private int costoAdicionalPorMinitos;

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
     * @return the minutosACelular
     */
    public int getMinutosACelular() {
        return minutosACelular;
    }

    /**
     * @param minutosACelular the minutosACelular to set
     */
    public void setMinutosACelular(int minutosACelular) {
        this.minutosACelular = minutosACelular;
    }

    /**
     * @return the llamadasFijas
     */
    public int getLlamadasFijas() {
        return llamadasFijas;
    }

    /**
     * @param llamadasFijas the llamadasFijas to set
     */
    public void setLlamadasFijas(int llamadasFijas) {
        this.llamadasFijas = llamadasFijas;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the costoAdicionalPorLlamada
     */
    public int getCostoAdicionalPorLlamada() {
        return costoAdicionalPorLlamada;
    }

    /**
     * @param costoAdicionalPorLlamada the costoAdicionalPorLlamada to set
     */
    public void setCostoAdicionalPorLlamada(int costoAdicionalPorLlamada) {
        this.costoAdicionalPorLlamada = costoAdicionalPorLlamada;
    }

    /**
     * @return the costoAdicionalPorMinitos
     */
    public int getCostoAdicionalPorMinitos() {
        return costoAdicionalPorMinitos;
    }

    /**
     * @param costoAdicionalPorMinitos the costoAdicionalPorMinitos to set
     */
    public void setCostoAdicionalPorMinitos(int costoAdicionalPorMinitos) {
        this.costoAdicionalPorMinitos = costoAdicionalPorMinitos;
    }

}
