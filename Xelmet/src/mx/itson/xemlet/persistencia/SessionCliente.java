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
public class SessionCliente {

    public List<Cliente> obtenerTodos(int pos) {

        List<Cliente> clientes = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);
            clientes = session.createQuery(criteria).getResultList();
            clientes.size();
            clientes.get(pos).getLlamadas().size();

            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurió un error al intentar obtener registros");
        }
        return clientes;
    }

    public void AgregarCliente(Cliente client) {

        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);

            //
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
            session.close();
            //

            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurió un error al intentar obtener registros");
        }

    }

    public void EliminarCliente(int pos) {
         Cliente p = new Cliente();
            try {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();

                p = (Cliente) session.get(Cliente.class, obtenerTodos(pos).get(pos).getId());
                p.getLlamadas().clear();
                session.delete(p);
            session.delete(p);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener registros");
        }
    }

//     public List<Llamada> obtenerLlamadas(int pos) {
//        List<Llamada> canciones = new ArrayList<>();
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
//            criteria.from(Cliente.class);
//            canciones = (List<Llamada>) session.createQuery(criteria).getResultList().get(pos).getLlamadas();
//
//            //hace una accion para que de tiempo al procesamie  nto
//            System.out.println(""+canciones.size());
//            System.out.println(""+canciones.get(0).getId());
//            //System.out.println(""+canciones.get(1).getId());
//            session.close();
//
//        } catch (Exception ex) {
//            System.out.println("Ocurió un error al intentar obtener registros de las canciones: " + ex.getMessage());
//        }
//        return canciones;
//    }
}
