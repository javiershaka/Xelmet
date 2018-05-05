/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.xemlet.nucleo.entidades.Cliente;
import mx.itson.xemlet.nucleo.entidades.Llamada;
import org.hibernate.Session;

/**
 *
 * @author javiershaka
 */
public class ControladorCliente {


   
  
    public List<Cliente> obtenerTodos() {
       
        List<Cliente> companias = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);
            companias = session.createQuery(criteria).getResultList();
            System.out.println(""+companias.get(0).getDomicilio());
            System.out.println("nombre del paquete "+companias.get(0).getPaquete().getNombre());
          
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurió un error al intentar obtener registros");
        }
        return companias;
    }
     public List<Llamada> obtenerLlamadas(int pos) {
        List<Llamada> canciones = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);
            canciones = (List<Llamada>) session.createQuery(criteria).getResultList().get(pos).getLlamadas();
         
            //hace una accion para que de tiempo al procesamie  nto
            System.out.println(""+canciones.size());
           
            session.close();

        } catch (Exception ex) {
            System.out.println("Ocurió un error al intentar obtener registros de las canciones: " + ex.getMessage());
        }
        return canciones;
    }

}

