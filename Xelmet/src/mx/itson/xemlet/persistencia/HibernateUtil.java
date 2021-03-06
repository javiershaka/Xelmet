package mx.itson.xemlet.persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Define el inicio de sesión de Hibernate.
 *
 * @author
 * @version 0.1
 */
public class HibernateUtil {

    private static StandardServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources metaSources = new MetadataSources(serviceRegistry);
                Metadata metadata = metaSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception ex) {
                System.out.println("Ocurrió un error al intentar generar la sesión de Hibernate. Descripción: " + ex.getMessage());
                if (serviceRegistry != null) {
                    StandardServiceRegistryBuilder.destroy(serviceRegistry);
                }
            }
        }
        return sessionFactory;
    }
    

    public static void destroy() {
        if (serviceRegistry != null) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }
}