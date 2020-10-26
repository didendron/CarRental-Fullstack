package com.carrental.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.carrental.model.Car;
import com.carrental.model.City;
import com.carrental.model.Reservation;




public class CreateDatabaseWithHibernate {
	
	@Test
	public void creatDatabase() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Car.class);
		configuration.addAnnotatedClass(Reservation.class);
		configuration.addAnnotatedClass(City.class);
		ServiceRegistry serviceRegistry
        = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();
 
       
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);
 
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         
        //Reservation reservation=new Reservation();
        //reservation.setAge(4);
      
         
        //session.save(reservation);
        
         
        session.getTransaction().commit();
        session.close();        
		
	}
	

}
