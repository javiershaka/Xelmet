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
public class ControladorPaquete {
    public List<Paquete> obtenerTodos() {
        List<Paquete> companias = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Paquete> criteria = builder.createQuery(Paquete.class);
            criteria.from(Paquete.class);
            companias = session.createQuery(criteria).getResultList();
            System.out.println(""+companias.get(0).getId());
            System.out.println(""+companias.get(0).getLlamadasFijas());
            System.out.println(""+companias.get(0).getNombre());
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurió un error al intentar obtener registros");
        }
        return companias;
    }
    
}
