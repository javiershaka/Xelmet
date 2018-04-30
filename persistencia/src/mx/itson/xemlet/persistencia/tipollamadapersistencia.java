/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.xemlet.persistencia;

import mx.itson.xemlet.entidades.tipollamada;
import mx.itson.xemlet.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author mppme
 */
public class tipollamadapersistencia {
    
    public void llamadaLocal (tipollamada t){
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(t);
        tx.commit();
        session.close();
    }
    
    public void llamadaCeular (tipollamada t){
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Session session;
        session = sesion.openSession();
        Transaction tx = session.beginTransaction();
        session.save(t);
        tx.commit();
        session.close();
    }
    
}
