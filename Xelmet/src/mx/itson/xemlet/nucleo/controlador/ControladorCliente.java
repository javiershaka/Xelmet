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

    public void AgregarCliente() {
        Cliente cliente = new Cliente();
        cliente.setDomicilio("" + FrameAgregarCliente.txtDomicilio.getText());
        cliente.setNombre("" + FrameAgregarCliente.txtNombre.getText());
        cliente.setNumeroTelefonico("" + FrameAgregarCliente.txtNumeroTelefonico.getText());
        cliente.setPaquete(new SessionPaquete().obtenerTodos().get(FrameAgregarCliente.cmbxPaquete.getSelectedIndex()));
        
        new SessionCliente().AgregarCliente(cliente);
    }

}
