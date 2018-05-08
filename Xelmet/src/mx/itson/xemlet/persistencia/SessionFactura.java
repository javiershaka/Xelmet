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
import mx.itson.xemlet.nucleo.entidades.Factura;
import org.hibernate.Session;


/**
 *
 * @author javiershaka
 */
public class SessionFactura {
    public List<Factura> obtenerTodos() {
        List<Factura> paquetes = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Factura> criteria = builder.createQuery(Factura.class);
            criteria.from(Factura.class);
            paquetes = session.createQuery(criteria).getResultList();
            paquetes.size();
          
            session.close();
        } catch (Exception ex) {
            System.out.println("Ocurió un error al intentar obtener registros");
        }
        return paquetes;
    }
    
    
    
    
}
