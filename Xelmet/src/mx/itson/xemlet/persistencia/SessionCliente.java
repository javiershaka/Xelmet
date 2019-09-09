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
     *
     * @param pos devuelve la posicion de la lista que se seleciona
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
     *
     * @param client recive un parametro de objeto cliente para agregarlo
     */
    public void AgregarCliente(Cliente client) {

        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
            criteria.from(Cliente.class);

            // hace la transicion para verificar 
            session.beginTransaction();
            // se guarda el objeto cliente
            //dato se tiene que tener el id del cliente a modificar previamente para que sea una modificacion exitosa
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
     *
     * @param pos recive el parametro de la posicion de la tabla
     */
    public void EliminarCliente(int pos) {
        Cliente p = new Cliente();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            // se crea un casting donde el objeto se toma referencia al objeto y la posicion para obtener el id 
            // ya que necesitas el id para poder eliminarlo en la base de datos 
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
     *
     * @param c recive un parametro de objeto cliente para modificarlo
     */
    public void modificarCliente(Cliente c) {
        try {
            Cliente client;
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            // hace un castin para que se cree con el objeto y sacar el id del cliente ya que es necesario para la modificacion del cliente ne la base de datos
  
            session.update(c);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener registros");
        }

    }

}
