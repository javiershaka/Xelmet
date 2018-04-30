
package mx.itson.xelmet.nucleo.entidades;


public class Paquete {
    private int id;
    private int minutosACelular;
    private int llamadasFijas;
    private double precio;

    /**
     * @return the id
     */
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
}
