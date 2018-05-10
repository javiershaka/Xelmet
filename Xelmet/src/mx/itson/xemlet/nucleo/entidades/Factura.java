/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author javiershaka en esta clase guarda todos los datos de la factura como
 * id de la factura idCliente que ahce referencia al id de cliente nombre que
 * hace referencia a nombre del cliente fecha , llamadas movil que son los
 * minutos que realizo en total en ese mes de factura llamadas fijas que son las
 * llamadas fijas que realizo y las llamadas en total llamadas realizadas costo
 * del paquete que guarda nomas el dato del costo en ese momento del facturado o
 * de la fecha en si cargos adicionales por si se pasa de las condiciones del
 * paquete y total ningun dato esta relacionado ya que si estubieran se
 * modificarian cuando actualizaramos los paquetes y en si no guardaria ningun
 * dato
 */
@Entity
public class Factura {

    private int id;
    private int idCliente;
    private String nombre;
    private String fecha;
    private int llamadasMovil;
    private int llamadasFijas;
    private int llamadasRealizadas;
    private double costoPaquete;
    private double cargosAdicionales;
    private double total;

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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the llamadasMovil
     */
    public int getLlamadasMovil() {
        return llamadasMovil;
    }

    /**
     * @param llamadasMovil the llamadasMovil to set
     */
    public void setLlamadasMovil(int llamadasMovil) {
        this.llamadasMovil = llamadasMovil;
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
     * @return the llamadasRealizadas
     */
    public int getLlamadasRealizadas() {
        return llamadasRealizadas;
    }

    /**
     * @param llamadasRealizadas the llamadasRealizadas to set
     */
    public void setLlamadasRealizadas(int llamadasRealizadas) {
        this.llamadasRealizadas = llamadasRealizadas;
    }

    /**
     * @return the costoPaquete
     */
    public double getCostoPaquete() {
        return costoPaquete;
    }

    /**
     * @param costoPaquete the costoPaquete to set
     */
    public void setCostoPaquete(double costoPaquete) {
        this.costoPaquete = costoPaquete;
    }

    /**
     * @return the cargosAdicionales
     */
    public double getCargosAdicionales() {
        return cargosAdicionales;
    }

    /**
     * @param cargosAdicionales the cargosAdicionales to set
     */
    public void setCargosAdicionales(double cargosAdicionales) {
        this.cargosAdicionales = cargosAdicionales;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the id
     */
}
