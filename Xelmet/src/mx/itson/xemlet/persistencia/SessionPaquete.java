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
    
}
