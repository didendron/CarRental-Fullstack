package com.carrental.test;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.carrental.model.Car;
import com.carrental.model.City;
import com.carrental.model.Reservation;




public class InsertValuesIntoDatabase {
	
	@Test
	public void insertRecords() {
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
        
      
        
        Car car1=new Car();
        Car car2=new Car();
        Car car3=new Car(); 
        car1.setCarName("Toyota Avensis");
        car1.setPrice(350);
        car2.setCarName("Ford Focus");
        car2.setPrice(250);
        car3.setCarName("Seat Ibiza");
        car3.setPrice(300);
        
        ArrayList<Car> cars=new ArrayList<Car>(); 
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        
        City city1=new City();
        City city2=new City();
        City city3=new City();
        City city4=new City();
        City city5=new City();
        City city6=new City();
        City city7=new City();
        City city8=new City();
        City city9=new City();
        City city10=new City();
        City city11=new City();
        City city12=new City();
        
        city1.setCityName("Kraków");
        city2.setCityName("Gdañsk");
        city3.setCityName("Kielce");
        city4.setCityName("Katowice");
        city5.setCityName("Wroc³aw");
        city6.setCityName("Warszawa");
        city7.setCityName("Rzeszów");
        city8.setCityName("Szczecin");
        city9.setCityName("Zielona Góra");
        city10.setCityName("Bydgoszcz");
        city11.setCityName("Lublin");
        city12.setCityName("Gorzów");
        
        ArrayList<City> cities=new ArrayList<City>(); 
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);
        cities.add(city5);
        cities.add(city6);
        cities.add(city7);
        cities.add(city8);
        cities.add(city9);
        cities.add(city10);
        cities.add(city11);
        cities.add(city12);
        
        
        
        for(int i=0;i<3;i++) {
        	session.save(cars.get(i));
        
        }
        for(int i=0;i<12;i++) {
        	session.save(cities.get(i));
        
        }
        
      
       
        
      
      
   
        session.getTransaction().commit();
        session.close();        
		
	}
	

}
