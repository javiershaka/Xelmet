/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.controlador;

import mx.itson.xemlet.persistencia.SessionFactura;
import mx.itson.xemlet.persistencia.SessionCliente;
import mx.itson.xemlet.presentacion.Principal;
import mx.itson.xemlet.presentacion.Registro;
import mx.itson.xemlet.presentacion.FrameFactura;
import mx.itson.xemlet.nucleo.entidades.Factura;
/**
 *
 * @author javiershaka
 */
public class ControladorFactura {

    public void VerificarFacturar() {
        if (!FrameFactura.txtAño.getText().isEmpty() && FrameFactura.cbMes.getSelectedIndex() > 0) {

            SessionCliente cliente = new SessionCliente();
            int minutos = 0;
            int llamadas = 0;
            int llamadasCelular = 0;
            int llamadasRealizadas;
            int AdicionalCelular = 0;
            int AdicionalLlamadas = 0;
            double cargo = 0;
            double total;
            String fecha = "" + FrameFactura.cbMes.getSelectedItem().toString().toUpperCase() + "/" + FrameFactura.txtAño.getText().toUpperCase();
            System.out.println("" + fecha);

            for (int var = 0; var < Integer.parseInt("" + Registro.txtLlamadasRealizadas.getText()); var++) {

                if (cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getLlamadas().get(var).getFecha().toUpperCase().contains(fecha.toUpperCase())) {
                    if (cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getLlamadas().get(var).getTipoLlamada().equalsIgnoreCase("FIJA")) {
                        llamadas += 1;
                    }
                    if (cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getLlamadas().get(var).getTipoLlamada().equalsIgnoreCase("Movil")) {
                        System.out.println("paso 2");
                        minutos += cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getLlamadas().get(var).getDuracionMinutos();
                        llamadasCelular += 1;
                    }

                }
            }

            llamadasRealizadas = llamadas + llamadasCelular;
            FrameFactura.txtNombre.setText("" + Registro.txtNombreCliente.getText());
            FrameFactura.txtLlamadasFijas.setText("" + llamadas);
            FrameFactura.txtMinutosCelular.setText("" + minutos);
            FrameFactura.txtLlamadasRealizadas.setText("" + llamadasRealizadas);
            llamadas = llamadas - cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getLlamadasFijas();
            minutos = minutos - cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getMinutosACelular();
            if (llamadas > 0) {
                AdicionalLlamadas = llamadas * cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getCostoAdicionalPorLlamada();
            } else {
                AdicionalLlamadas = 0;
            }
            if (minutos > 0) {
                AdicionalCelular = minutos * cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getCostoAdicionalPorMinitos();
            } else {
                AdicionalCelular = 0;
            }
            cargo = AdicionalCelular + AdicionalLlamadas;
            total = cargo + cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getPrecio();
            FrameFactura.txtCostoPaquete.setText(""+cliente.obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getPaquete().getPrecio());
            FrameFactura.txtCargosAdicionales.setText(""+cargo);
            FrameFactura.txtTotal.setText(""+total);
        }

    }
    public void AgregarFactura(){
        Factura factura = new Factura();
        
        
    }

}
