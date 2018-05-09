/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.controlador;

import mx.itson.xemlet.nucleo.entidades.Cliente;
import mx.itson.xemlet.persistencia.SessionPaquete;
import mx.itson.xemlet.persistencia.SessionCliente;
import mx.itson.xemlet.presentacion.FrameAgregarCliente;

/**
 *
 * @author javiershaka
 */
public class ControladorCliente {
    /**
     * En este metodo se agrega cliente 
     */
    public void AgregarCliente() {
        

        //se crea un objeto de la clase cliente
            Cliente cliente = new Cliente();
            cliente.setDomicilio("" + FrameAgregarCliente.txtDomicilio.getText());
            cliente.setNombre("" + FrameAgregarCliente.txtNombre.getText());
            cliente.setNumeroTelefonico("" + FrameAgregarCliente.txtNumeroTelefonico.getText());
            cliente.setPaquete(new SessionPaquete().obtenerTodos().get(FrameAgregarCliente.cmbxPaquete.getSelectedIndex()));
                //manda a llamar al metodo agregar y devuelve el valor en objeto cliente
            new SessionCliente().AgregarCliente(cliente);
        
        

    }
    /**
     * en este metodo modifica el clente creando un nuevo cliente
     */

    public void ModificarCliente() {

        Cliente cliente = new Cliente();
        
        
        new SessionCliente().modificarCliente(cliente);

    }
    /**
     * En este metodo agregarOrModificarcliente es una validadcion para que de ahi se eecute uno de los dos metodos
     */
    public void AgregarOrModificarCliente() {
        if (FrameAgregarCliente.btnAgregar.getText().equalsIgnoreCase("Aceptar")) {
            AgregarCliente();
        } else {
            ModificarCliente();
        }
    }

}
