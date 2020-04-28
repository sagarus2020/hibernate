/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatenormal;
   
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;

/**
 *
 * @author usuario
 */

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateSession {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();

        } catch (HibernateException he) {
            System.out.println("Session Factory creation failure");
            throw he;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
//public class HibernateSession{
//
//    private static final SessionFactory sessionFactory=    buildSessionFactory();
//    private static Session session;
//    private static final SessionFactory    buildSessionFactory(){
//    Configuration configuration = new Configuration();
//    configuration.configure();
//    SessionFactory sessionFactory =configuration.buildSessionFactory(/*serviceRegistry*/);
//
//        return sessionFactory;
//    }
//    
//    
//
//    public static SessionFactory getSessionFactory() 
//    { 
//        return sessionFactory; 
//    }
//    public static Session getSession() 
//    { 
//        if(null==session){
//        session=sessionFactory.openSession();
//        }
//        return session; 
//    }
//} 

