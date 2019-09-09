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
    public void llenarFrame() {
        //variable para que acumle el costo por llamada
        int costLlamada = 0;
        //variable para que acumule el costo por minuto
        int costMinutos = 0;
        //contador para los minutos
        int contMinutos = 0;
        //variable para que almacene la posicion de a tabla
  
     
        // se toma el inicio de seccion y se obtiene el id identificador para cambiarlo en la base de datos
        SessionCliente sessionclient = new SessionCliente();
      
        //for para llamadas
        //condiciones para cobros adicionales-
 

    

    }

}
