package mx.itson.xemlet.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.xemlet.nucleo.entidades.Paquete;
import org.hibernate.Session;

/**
 *
 * @author javiershaka
 */
public class SessionPaquete {

    /**
     *
     * @return devuelve una lista de objetos de la clase paquete
     */
    public List<Paquete> obtenerTodos() {
        List<Paquete> paquetes = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Paquete> criteria = builder.createQuery(Paquete.class);
            criteria.from(Paquete.class);
            paquetes = session.createQuery(criteria).getResultList();
            paquetes.size();

            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurió un error al intentar obtener registros");
        }
        return paquetes;
    }

    /**
     *
     * @param p recibe como parametro un objeto de la clase paquete para poder
     * agregarlo
     */
    public void AgregarPaquete(Paquete p) {
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(p);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener registros");
        }

    }

    /**
     *
     * @param p recive como parametro un bjeto de la clase paquete para poder
     * modificarlo antes de modificar neceitas tener el id del paquete para que
     * ea una modificacion exitosa
     */
    public void ModificarPaquete(Paquete p) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.update(p);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurrió un error al intentar obtener registros");
        }
    }

}
