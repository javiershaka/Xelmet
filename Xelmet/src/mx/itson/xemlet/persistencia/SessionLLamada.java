package mx.itson.xemlet.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.xemlet.nucleo.entidades.Llamada;
import org.hibernate.Session;

/**
 *
 * @author javiershaka
 */
public class SessionLLamada {

    /**
     *
     * @return devuelve una lista de objetos llamada
     */
    public List<Llamada> obtenerTodos() {
        List<Llamada> llamadas = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Llamada> criteria = builder.createQuery(Llamada.class);
            criteria.from(Llamada.class);
            llamadas = session.createQuery(criteria).getResultList();
            llamadas.size();

            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurió un error al intentar obtener registros");
        }
        return llamadas;
    }

    /**
     *
     * @param llamada recive como parametro un objeto de la clase llamada para
     * poder agregarlo a la base de datos
     */
    public void AgregarLlamada(Llamada llamada) {

        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Llamada> criteria = builder.createQuery(Llamada.class);
            criteria.from(Llamada.class);

            //
            session.beginTransaction();
            session.save(llamada);
            session.getTransaction().commit();
            session.close();
            //

            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurió un error al intentar obtener registros");
        }
    }

}
