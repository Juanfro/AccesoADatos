/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author alumno
 */
public class SessionFactoryUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static SessionFactory createSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure();
        
        
        serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        System.out.println("Hibernate Annotation serviceRegistry created");

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    /*public SessionFactoryUtil getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }*/
}
