package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Edin Cekic
 */
public class HibernateUtil {
   private static SessionFactory sessionFactory;
   private static ServiceRegistry serviceRegistry;
   
   public static SessionFactory createSessionFactory() throws ClassNotFoundException{
       
       Configuration configuration = new Configuration();
       configuration.configure("hibernate.cfg.xml");
       serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
       return sessionFactory;
       
   }
  
}
