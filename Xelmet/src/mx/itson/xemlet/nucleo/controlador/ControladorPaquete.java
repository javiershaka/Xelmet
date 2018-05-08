/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.controlador;

import mx.itson.xemlet.nucleo.entidades.Paquete;
import mx.itson.xemlet.persistencia.SessionPaquete;
import mx.itson.xemlet.presentacion.FrameAgregarPaquete;
import mx.itson.xemlet.presentacion.Principal;

/**
 *
 * @author javiershaka
 */
public class ControladorPaquete {

    public void AgregarPaquete() {
        Paquete p = new Paquete();
        p.setNombre("" + FrameAgregarPaquete.txtNombre.getText());
        p.setMinutosACelular(Integer.parseInt("" + FrameAgregarPaquete.txtMinutosCelular.getText()));
        p.setLlamadasFijas(Integer.parseInt("" + FrameAgregarPaquete.txtLlamadasFijas.getText()));
        p.setPrecio(Double.parseDouble("" + FrameAgregarPaquete.txtPrecio.getText()));
        p.setCostoAdicionalPorMinitos(Integer.parseInt("" + FrameAgregarPaquete.txtMinutosAdicionales.getText()));
        p.setCostoAdicionalPorLlamada(Integer.parseInt("" + FrameAgregarPaquete.txtLlamadasAdicionales.getText()));
        System.out.println("antes de llamar " + p.getNombre());
        new SessionPaquete().AgregarPaquete(p);

    }

    public void EliminarPaquete() {

    }

    public void modificarPaquete() {
        Paquete p = new Paquete();
        p.setId(new SessionPaquete().obtenerTodos().get(Principal.tbPaquetes.getSelectedRow()).getId());
        p.setNombre("" + FrameAgregarPaquete.txtNombre.getText());
        p.setMinutosACelular(Integer.parseInt("" + FrameAgregarPaquete.txtMinutosCelular.getText()));
        p.setLlamadasFijas(Integer.parseInt("" + FrameAgregarPaquete.txtLlamadasFijas.getText()));
        p.setPrecio(Double.parseDouble("" + FrameAgregarPaquete.txtPrecio.getText()));
        p.setCostoAdicionalPorMinitos(Integer.parseInt("" + FrameAgregarPaquete.txtMinutosAdicionales.getText()));
        p.setCostoAdicionalPorLlamada(Integer.parseInt("" + FrameAgregarPaquete.txtLlamadasAdicionales.getText()));
        System.out.println("antes de llamar " + p.getNombre());

        new SessionPaquete().ModificarPaquete(p);

    }

    public void AgregarOModificarValidacion() {
        if (FrameAgregarPaquete.btnAgregar.getText().equalsIgnoreCase("Aceptar")) {

            AgregarPaquete();

        } else {
            modificarPaquete();

        }

    }
}
