/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.controlador;
import javax.swing.table.DefaultTableModel;
import mx.itson.xemlet.persistencia.SessionCliente;
import mx.itson.xemlet.persistencia.SessionPaquete;
import mx.itson.xemlet.presentacion.Principal;

/**
 *
 * @author javiershaka
 */
public class ControladorFramePrincipal {
    
    public void llenarTablaFramePrincipalClientes(){
        
        SessionCliente sesionCliente = new SessionCliente();
        DefaultTableModel tablaClientes = (DefaultTableModel) Principal.tbClientes.getModel();
        
        tablaClientes.setRowCount(0);
        for(int q = 0; q < sesionCliente.obtenerTodos(0).size(); q ++){
            tablaClientes.addRow(new Object[]{sesionCliente.obtenerTodos(q).get(q).getId()+"",""+sesionCliente.obtenerTodos(q).get(q).getNombre()});
            
        }
        Principal.tbClientes.setModel(tablaClientes);
        
        
        
    }
    
    public void llenarTablaFramePrincipalPaquetes(){
        SessionPaquete sesionPaquete = new SessionPaquete();
        DefaultTableModel tablaPaquetes = (DefaultTableModel) Principal.tbPaquetes.getModel();
        
        tablaPaquetes.setRowCount(0);
        for(int a = 0; a < sesionPaquete.obtenerTodos().size(); a ++){
            tablaPaquetes.addRow(new Object[]{""+sesionPaquete.obtenerTodos().get(a).getId(),""+sesionPaquete.obtenerTodos().get(a).getNombre(), ""+sesionPaquete.obtenerTodos().get(a).getPrecio()});
            
        }
        Principal.tbPaquetes.setModel(tablaPaquetes);
        
    }
    
}
