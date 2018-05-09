/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.controlador;
import javax.swing.table.DefaultTableModel;
import mx.itson.xemlet.presentacion.Registro;
import mx.itson.xemlet.presentacion.Principal;
import mx.itson.xemlet.persistencia.SessionCliente;

/**
 *
 * @author javiershaka
 */
public class ControladorFrameRegistro {
    //cambia la variable para acceder el diferente tipo de cliente del  0 al 4 por lo pronto
    
    /**
     * este metodo solo llena el frame registro con los datos del cliente
     */
    public  void llenarFrame (){
        //variable para que acumle el costo por llamada
        int costLlamada = 0;
        //variable para que acumule el costo por minuto
        int costMinutos = 0;
        //contador para los minutos
        int contMinutos= 0;
        //variable para que almacene la posicion de a tabla
        int var = Principal.tbClientes.getSelectedRow();
        DefaultTableModel tablaFijas = (DefaultTableModel) Registro.tbLlamadasFijas.getModel();
        DefaultTableModel tablaMovil = (DefaultTableModel) Registro.tbLlamadasMovil.getModel();
        tablaFijas.setRowCount(0);
        tablaMovil.setRowCount(0);
        
        SessionCliente sessionclient = new SessionCliente();
        Registro.txtLlamadasRealizadas.setText(""+sessionclient.obtenerTodos(var).get(var).getLlamadas().size());
        Registro.txtLlamadasFijas.setText(""+sessionclient.obtenerTodos(var).get(var).getPaquete().getLlamadasFijas());
        Registro.txtMinutosACelular.setText(""+sessionclient.obtenerTodos(var).get(var).getPaquete().getMinutosACelular());
        Registro.txtNoTelefonico.setText(""+sessionclient.obtenerTodos(var).get(var).getNumeroTelefonico());
        Registro.txtNombreCliente.setText(""+sessionclient.obtenerTodos(var).get(var).getNombre());
        Registro.txtNombrePaquete.setText(""+sessionclient.obtenerTodos(var).get(var).getPaquete().getNombre());
        Registro.txtPrecio.setText(""+sessionclient.obtenerTodos(var).get(var).getPaquete().getPrecio());
        Registro.txtRegistroCliente.setText(""+sessionclient.obtenerTodos(var).get(var).getId());
        //for para llamadas
        for(int i = 0 ; i < sessionclient.obtenerTodos(var).get(var).getLlamadas().size(); i++){
            //condicion para llamadas fijas
            if(sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getTipoLlamada().equalsIgnoreCase("FIJA")){
                tablaFijas.addRow(new Object[]{""+sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getReceptor(),"" +sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getFecha(), ""+sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getDuracionMinutos()});
                
            }
            //condicion para llamadas moviles
            if(sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getTipoLlamada().equalsIgnoreCase("Movil")){
                tablaMovil.addRow(new Object[]{""+sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getReceptor(),"" +sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getFecha(), ""+sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getDuracionMinutos()});
                contMinutos += sessionclient.obtenerTodos(var).get(var).getLlamadas().get(i).getDuracionMinutos();
            }
            
        }
        Registro.txtLlamadasRealizadasFijas.setText(""+tablaFijas.getRowCount());
        Registro.txtLlamadasRealizadasMovil.setText(""+contMinutos);
        
        costLlamada =tablaFijas.getRowCount()- sessionclient.obtenerTodos(var).get(var).getPaquete().getLlamadasFijas();
        costMinutos = contMinutos - sessionclient.obtenerTodos(var).get(var).getPaquete().getCostoAdicionalPorMinitos();
        //condiciones para cobros adicionales-
        if(costLlamada > 0){
            costLlamada = costLlamada * sessionclient.obtenerTodos(var).get(var).getPaquete().getCostoAdicionalPorLlamada();
            Registro.txtCostoAdicionalLlamada.setText(""+costLlamada);
        }
        else{
            Registro.txtCostoAdicionalLlamada.setText("0");
            
        }
        
        if(costMinutos > 0){
            costMinutos = costMinutos * sessionclient.obtenerTodos(var).get(var).getPaquete().getCostoAdicionalPorMinitos();
            Registro.txtCostoAdicionalMinutos.setText(""+costMinutos);
        }else{
            Registro.txtCostoAdicionalMinutos.setText("0");
        }
        
        
        Registro.tbLlamadasFijas.setModel(tablaFijas);
        Registro.tbLlamadasMovil.setModel(tablaMovil);
        
        
        
    }
    
}
