
package mx.itson.xemlet.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author mppme
 */
@Entity
public class paquete {
    private int idpaquete;
    private int minutosCelular;
    private double precio;
    private int llamadasFijas;
    
    @Id
    @GeneratedValue
    public int getId() {
        return idpaquete;
    }

    public int getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(int idpaquete) {
        this.idpaquete = idpaquete;
    }

    public int getMinutosCelular() {
        return minutosCelular;
    }

    public void setMinutosCelular(int minutosCelular) {
        this.minutosCelular = minutosCelular;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getLlamadasFijas() {
        return llamadasFijas;
    }

    public void setLlamadasFijas(int llamadasFijas) {
        this.llamadasFijas = llamadasFijas;
    }
    
}
