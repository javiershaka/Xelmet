/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo.controlador;
import mx.itson.xemlet.persistencia.SessionCliente;
import mx.itson.xemlet.persistencia.SessionLLamada;
import mx.itson.xemlet.nucleo.entidades.Llamada;
import mx.itson.xemlet.presentacion.Principal;
import mx.itson.xemlet.presentacion.FrameAgregarLlamada;

/**
 *
 * @author javiershaka
 */
public class ControladorLlamada {
    /**
     * metodo para agregar llamada a cliente
     */
    public void AgregarLlamada(){
        
        Llamada llamada = new Llamada();
        llamada.setDuracionMinutos(Integer.parseInt(""+FrameAgregarLlamada.txtDuracion.getText()));
        llamada.setFecha(""+FrameAgregarLlamada.cbDias.getSelectedItem()+"/"+FrameAgregarLlamada.cbMes.getSelectedItem()+"/"+FrameAgregarLlamada.txtAño.getText());
        llamada.setReceptor(""+FrameAgregarLlamada.txtReceptor.getText());
        llamada.setTipoLlamada(""+FrameAgregarLlamada.comboboxTipo.getSelectedItem());
        
       
        new SessionLLamada().AgregarLlamada(llamada);
    
        
    }
    
    
    
}
