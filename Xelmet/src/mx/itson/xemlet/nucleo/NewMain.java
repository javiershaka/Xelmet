/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.nucleo;
import mx.itson.xemlet.persistencia.SessionCliente;
import mx.itson.xemlet.persistencia.SessionLLamada;
import mx.itson.xemlet.persistencia.SessionPaquete;
import mx.itson.xemlet.persistencia.SessionCliente;
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
       // new SessionPaquete().obtenerTodos().size();
          // new SessionLLamada().obtenerTodos();
          new SessionCliente().obtenerTodos(1);
         //new SessionCliente().obtenerLlamadas(0);
   
       
        
    }
    
}
