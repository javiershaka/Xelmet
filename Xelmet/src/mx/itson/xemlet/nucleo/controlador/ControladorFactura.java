/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.controlador;
import javax.swing.table.DefaultTableModel;
import mx.itson.xemlet.presentacion.Registro;
import mx.itson.xemlet.persistencia.SessionCliente;

/**
 *
 * @author javiershaka
 */
public class ControladorFactura {
    //cambia la variable para acceder el diferente tipo de cliente del  0 al 4 por lo pronto
    int var  = 4;
    
    public  void llenarFrame (){
        DefaultTableModel tablaFijas = (DefaultTableModel) Registro.tbLlamadasFijas.getModel();
        DefaultTableModel tablaMovil = (DefaultTableModel) Registro.tbLlamadasMovil.getModel();
        tablaFijas.setRowCount(0);
        tablaMovil.setRowCount(0);
        SessionCliente sessionclient = new SessionCliente();
        
        Registro.txtLlamadasFijas.setText(""+sessionclient.obtenerTodos(var).get(var).getPaquete().getLlamadasFijas());
        Registro.txtMinutosACelular.setText(""+sessionclient.obtenerTodos(var).get(var).getPaquete().getMinutosACelular());
        Registro.txtNoTelefonico.setText(""+sessionclient.obtenerTodos(var).get(var).getNumeroTelefonico());
        Registro.txtNombreCliente.setText(""+sessionclient.obtenerTodos(var).get(var).getNombre());
        Registro.txtNombrePaquete.setText(""+sessionclient.obtenerTodos(var).get(var).getPaquete().getNombre());
        Registro.txtPrecio.setText(""+sessionclient.obtenerTodos(var).get(var).getPaquete().getPrecio());
        Registro.txtRegistroCliente.setText(""+sessionclient.obtenerTodos(var).get(var).getId());
        System.out.println(""+sessionclient.obtenerTodos(var).get(var).getLlamadas().size());
        for(int i = 0 ; i < sessionclient.obtenerTodos(var).get(var).getLlamadas().size(); i++){
            if(sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getTipoLlamada().equalsIgnoreCase("FIJA")){
                tablaFijas.addRow(new Object[]{""+sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getReceptor(),"" +sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getFecha(), ""+sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getDuracionMinutos()});
                
            }
            if(sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getTipoLlamada().equalsIgnoreCase("Movil")){
                tablaMovil.addRow(new Object[]{""+sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getReceptor(),"" +sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getFecha(), ""+sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getDuracionMinutos()});
            }
            
        }
        Registro.txtLlamadasRealizadasFijas.setText(""+tablaFijas.getRowCount());
        Registro.txtLlamadasRealizadasMovil.setText(""+tablaMovil.getRowCount());
        Registro.tbLlamadasFijas.setModel(tablaFijas);
        Registro.tbLlamadasMovil.setModel(tablaMovil);
        
    }
    
}
