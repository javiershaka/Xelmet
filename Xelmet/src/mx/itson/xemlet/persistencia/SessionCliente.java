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
import mx.itson.xemlet.presentacion.FrameAgregarCliente;
import mx.itson.xemlet.presentacion.Principal;
import org.hibernate.Session;

/**
 *
 * @author javiershaka
 */
public class SessionCliente {
/**
 * metodo para obtener todos los datos de cliente
 * @param pos devuelve la posicion de la tabla que se seleciona
 * @return 
 */
    public List<Cliente> obtenerTodos(int pos) {

        List<Cliente> clientes = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);
            clientes = session.createQuery(criteria).getResultList();
            // se hace clientes.size() y clientes get llamadas para no añadir la propuedad lazy para que no se corte el reccorrido
            clientes.size();
            clientes.get(pos).getLlamadas().size();

            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurió un error al intentar obtener registros");
        }
        return clientes;
    }
/**
 * metodo para agregar cliente en base de tados
 * @param client recive un parametro de objeto cliente para agregarlo
 */
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
    /**
     * metodo para eliminar cliente
     * @param pos recive el parametro de la posicion de la tabla
     */
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
    /**
     * metodo para modificar cliente 
     * @param c recive un parametro de objeto cliente para modificarlo
     */
    public void modificarCliente(Cliente c) {
        try {
            Cliente client;
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
             c = (Cliente) session.get(Cliente.class, obtenerTodos(Principal.tbClientes.getSelectedRow()).get(Principal.tbClientes.getSelectedRow()).getId());
            c.setDomicilio("" + FrameAgregarCliente.txtDomicilio.getText());
            c.setNombre("" + FrameAgregarCliente.txtNombre.getText());
            c.setNumeroTelefonico("" + FrameAgregarCliente.txtNumeroTelefonico.getText());
            c.setPaquete(new SessionPaquete().obtenerTodos().get(FrameAgregarCliente.cmbxPaquete.getSelectedIndex()));
            session.update(c);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener registros");
        }

    }


}
