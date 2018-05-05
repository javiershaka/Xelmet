/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo;
import mx.itson.xemlet.persistencia.ControladorCliente;
import mx.itson.xemlet.persistencia.ControladorLLamada;
import mx.itson.xemlet.persistencia.ControladorPaquete;
import mx.itson.xemlet.persistencia.ControladorCliente;
/**
 *
 * @author javiershaka
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //new ControladorPaquete().obtenerTodos().get(0);
       //     new ControladorLLamada().obtenerTodos().get(0);
           new ControladorCliente().obtenerTodos();
           new ControladorCliente().obtenerLlamadas(1);
       
        
    }
    
}
