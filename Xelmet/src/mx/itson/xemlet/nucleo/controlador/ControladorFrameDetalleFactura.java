/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.controlador;

import javax.swing.table.DefaultTableModel;
import mx.itson.xemlet.persistencia.SessionFactura;
import mx.itson.xemlet.presentacion.FrameDetalleFactura;

/**
 *
 * @author javiershaka
 */
public class ControladorFrameDetalleFactura {

    /**
     * en este metodo nomas se llena el frame detalle factura
     */
    public void llenarTablaFrameDetalleFactura() {
        SessionFactura sesionFactura = new SessionFactura();
        DefaultTableModel tablaFactura = (DefaultTableModel) FrameDetalleFactura.tbDetalleFactura.getModel();

        tablaFactura.setRowCount(0);
        for (int a = 0; a < sesionFactura.obtenerTodos().size(); a++) {
            tablaFactura.addRow(new Object[]{"" + sesionFactura.obtenerTodos().get(a).getId(),
                "" + sesionFactura.obtenerTodos().get(a).getIdCliente(),
                "" + sesionFactura.obtenerTodos().get(a).getNombre(),
                "" + sesionFactura.obtenerTodos().get(a).getFecha(),
                "" + sesionFactura.obtenerTodos().get(a).getLlamadasMovil(),
                "" + sesionFactura.obtenerTodos().get(a).getLlamadasFijas(),
                "" + sesionFactura.obtenerTodos().get(a).getLlamadasRealizadas(),
                "" + sesionFactura.obtenerTodos().get(a).getCostoPaquete(),
                "" + sesionFactura.obtenerTodos().get(a).getCargosAdicionales(),
                "" + sesionFactura.obtenerTodos().get(a).getTotal()});

        }
        FrameDetalleFactura.tbDetalleFactura.setModel(tablaFactura);

    }

}
