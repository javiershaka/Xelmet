/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.controlador;

import java.awt.Color;
import mx.itson.xemlet.nucleo.entidades.Cliente;
import mx.itson.xemlet.persistencia.SessionPaquete;
import mx.itson.xemlet.persistencia.SessionCliente;
import mx.itson.xemlet.presentacion.FrameAgregarCliente;
import mx.itson.xemlet.presentacion.Principal;

/**
 *
 * @author javiershaka
 */
public class ControladorCliente {

    public void AgregarCliente() {
        

       
            Cliente cliente = new Cliente();
            cliente.setDomicilio("" + FrameAgregarCliente.txtDomicilio.getText());
            cliente.setNombre("" + FrameAgregarCliente.txtNombre.getText());
            cliente.setNumeroTelefonico("" + FrameAgregarCliente.txtNumeroTelefonico.getText());
            cliente.setPaquete(new SessionPaquete().obtenerTodos().get(FrameAgregarCliente.cmbxPaquete.getSelectedIndex()));
            
            new SessionCliente().AgregarCliente(cliente);
        
        

    }

    public void ModificarCliente() {

        Cliente cliente = new Cliente();
        cliente.setId(new SessionCliente().obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getId());
        cliente.setDomicilio("" + FrameAgregarCliente.txtDomicilio.getText());
        cliente.setNombre("" + FrameAgregarCliente.txtNombre.getText());
        cliente.setNumeroTelefonico("" + FrameAgregarCliente.txtNumeroTelefonico.getText());
        cliente.setPaquete(new SessionPaquete().obtenerTodos().get(FrameAgregarCliente.cmbxPaquete.getSelectedIndex()));
        new SessionCliente().modificarCliente(cliente);

    }

    public void AgregarOrModificarCliente() {
        if (FrameAgregarCliente.btnAgregar.getText().equalsIgnoreCase("Aceptar")) {
            AgregarCliente();
        } else {
            ModificarCliente();
        }
    }

}
