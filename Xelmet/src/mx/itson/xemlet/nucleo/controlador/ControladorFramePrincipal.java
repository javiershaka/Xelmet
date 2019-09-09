/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.controlador;

import javax.swing.table.DefaultTableModel;
import mx.itson.xemlet.persistencia.SessionCliente;
import mx.itson.xemlet.persistencia.SessionFactura;
import mx.itson.xemlet.persistencia.SessionPaquete;
import mx.itson.xemlet.presentacion.Principal;

/**
 *
 * @author javiershaka
 */
public class ControladorFramePrincipal {

    /**
     * en este metodo se llena la tabla principal de clientes
     */

    public void llenarTablaFramePrincipalClientes() {

        SessionCliente sesionCliente = new SessionCliente();
   

       

    }

    /**
     * este metodo sirve para llenar la tabla paquetes del menu principal
     */
    public void llenarTablaFramePrincipalPaquetes() {
        SessionPaquete sesionPaquete = new SessionPaquete();
        DefaultTableModel tablaPaquetes = (DefaultTableModel) Principal.tbPaquetes.getModel();

        tablaPaquetes.setRowCount(0);
        for (int a = 0; a < sesionPaquete.obtenerTodos().size(); a++) {
            tablaPaquetes.addRow(new Object[]{"" + sesionPaquete.obtenerTodos().get(a).getId(), "" + sesionPaquete.obtenerTodos().get(a).getNombre(), "" + sesionPaquete.obtenerTodos().get(a).getPrecio()});

        }
        Principal.tbPaquetes.setModel(tablaPaquetes);

    }

    /**
     * en este metodo se llana la tabla factura del menu principal
     */
    public void llenarTablaFramePrincipalFactura() {
        SessionFactura sesionFactura = new SessionFactura();
        DefaultTableModel tablaFactura = (DefaultTableModel) Principal.tbFactura.getModel();

        tablaFactura.setRowCount(0);
        for (int a = 0; a < sesionFactura.obtenerTodos().size(); a++) {
            tablaFactura.addRow(new Object[]{"" + sesionFactura.obtenerTodos().get(a).getIdCliente(), "" + sesionFactura.obtenerTodos().get(a).getLlamadasRealizadas(), "" + sesionFactura.obtenerTodos().get(a).getFecha(), "" + sesionFactura.obtenerTodos().get(a).getTotal()});

        }
        Principal.tbFactura.setModel(tablaFactura);

    }

}
