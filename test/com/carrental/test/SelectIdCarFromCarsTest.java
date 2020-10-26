package com.carrental.test;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.carrental.model.Car;
import com.carrental.model.City;
import com.carrental.model.Reservation;

public class SelectIdCarFromCarsTest {
	
	private SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Car.class);
		configuration.addAnnotatedClass(Reservation.class);
		configuration.addAnnotatedClass(City.class);
		ServiceRegistry serviceRegistry
        = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();
		
		SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);
		
		return sessionFactory;
	}
	
	private void selectCarID(Car car) {
		
		Session session=this.getSessionFactory().openSession();
		session.beginTransaction();
		
		
		
		String hqlSelect="select id from Car where carName=:carName";
		TypedQuery<Integer> query=session.createQuery(hqlSelect, Integer.class);
		query.setParameter("carName", car.getCarName());
		Integer carid = query.getSingleResult();
		
		System.out.println(carid);
		
	
		
		
		session.getTransaction().commit();
        session.close();  
        
        
		
	}
	
	@Test
	public void test() {
		Car car=new Car();
		car.setCarName("Seat Ibiza");
		this.selectCarID(car);
	}

}
