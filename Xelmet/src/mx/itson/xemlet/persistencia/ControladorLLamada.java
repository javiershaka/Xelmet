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
public class ControladorLLamada {
    
     public List<Llamada> obtenerTodos() {
        List<Llamada> companias = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Llamada> criteria = builder.createQuery(Llamada.class);
            criteria.from(Llamada.class);
            companias = session.createQuery(criteria).getResultList();
            System.out.println("asd"+companias.get(1).getReceptor());
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurió un error al intentar obtener registros");
        }
        return companias;
    }
    
}
