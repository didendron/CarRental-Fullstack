package com.carrental.dao;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.carrental.model.Car;
import com.carrental.model.City;
import com.carrental.model.Reservation;

public class CarRentalDao {
	
	private SessionFactory getSessionFactory() {
		//on localhost
		/*
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(Car.class);
		configuration.addAnnotatedClass(Reservation.class);
		configuration.addAnnotatedClass(City.class);
		ServiceRegistry serviceRegistry
        = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();
		
		SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);*/
		
		//on heroku
		
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Car.class);
		configuration.addAnnotatedClass(Reservation.class);
		configuration.addAnnotatedClass(City.class);
		
		Map<String,String> jdbcUrlSettings = new HashMap<>();
		String jdbcDbUrl = System.getenv("JDBC_DATABASE_URL");
		if (null != jdbcDbUrl) {
		  jdbcUrlSettings.put("hibernate.connection.url", System.getenv("JDBC_DATABASE_URL"));
		}
		
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().
			    configure("/src/hibernate.cfg.xml").
			    applySettings(jdbcUrlSettings).
			    build();
		
		SessionFactory sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);
	
		
		return sessionFactory;
	}
	
	private Integer selectCarId(Car car) {
		Session session=this.getSessionFactory().openSession();
		session.beginTransaction();
		
		String hqlSelect="select id from Car where carName=:carName";
		TypedQuery<Integer> query=session.createQuery(hqlSelect, Integer.class);
		query.setParameter("carName", car.getCarName());
		Integer carid = query.getSingleResult();
		
		session.getTransaction().commit();
        session.close();  
        
		return carid;
		
		
	}
	
	private Integer selectCityId(City city) {
		Session session=this.getSessionFactory().openSession();
		session.beginTransaction();
		
		String hqlSelect="select id from City where cityName=:cityName";
		TypedQuery<Integer> query=session.createQuery(hqlSelect, Integer.class);
		query.setParameter("cityName", city.getCityName());
		Integer cityid = query.getSingleResult();
		
		session.getTransaction().commit();
        session.close();  
        
		return cityid;
		
		
	}
	
	public void insertReservation(Reservation reservation,Car car,City city) {
		
		Session session=this.getSessionFactory().openSession();
		session.beginTransaction();
		
		car.setId(this.selectCarId(car));
		city.setId(this.selectCityId(city));
		
		reservation.setCar(car);
		reservation.setCity(city);
		session.save(reservation);
		
		session.getTransaction().commit();
        session.close();  
        
        
		
	}
	
	public List<Car> checkAvailabilityOfCar(Date dateOfReceipt, Date dateOfReturn,String cityName){
		List<Car> cars=new ArrayList<>();

		Session session=this.getSessionFactory().openSession();
		session.beginTransaction();
		
		//in every city we have only one car of a given type
		String hql="select c from Car as c where c "
				+"not in "
				+"( select c from Car as c "
				+ "inner join Reservation r on c.id=r.car "
				+ "inner join City t on r.city=t.id "
				+ "where (t.cityName=:cityName) "
				+ "and ((:dateOfReceipt between r.dateOFReceipt and r.dateOFReturn) or (:dateOfReturn between r.dateOFReceipt and r.dateOFReturn))) ";
				
		
		TypedQuery<Car> query=session.createQuery(hql, Car.class);
		query.setParameter("cityName", cityName);
		query.setParameter("dateOfReceipt", dateOfReceipt);
		query.setParameter("dateOfReturn", dateOfReturn);
		
		List<Car> listResult=query.getResultList();
		
		for (Car car : listResult) {
		    cars.add(car);
		}  
		
		session.getTransaction().commit();
        session.close();  
        
		
		return cars;
	}
	
	

}
