package com.carrental.test;

import java.sql.Date;

import org.junit.Test;

import com.carrental.dao.CarRentalDao;
import com.carrental.model.Car;
import com.carrental.model.City;
import com.carrental.model.Reservation;

public class InsertReservationTest {
	
	
	@Test
	public void Test() {
		
		    Reservation reservation1=new Reservation();
	        reservation1.setFirstName("Janusz");
	        reservation1.setLastName("Kowalski");
	        reservation1.setAge(37);
	        reservation1.setAddress("Nawojowska 52");
	        reservation1.setTown("Kraków");
	        reservation1.setEmail("rrtyu@wp.pl");
	        reservation1.setPhone(345678987);
	        reservation1.setPostalCode("33-002");
	        reservation1.setDateOFReceipt(Date.valueOf("2020-11-15"));
	        reservation1.setDateOFReturn(Date.valueOf("2020-11-19"));
	        Reservation reservation2=new Reservation();
	        reservation2.setFirstName("Marian");
	        reservation2.setLastName("Nowak");
	        reservation2.setAge(30);
	        reservation2.setAddress("Grunwaldzka 30");
	        reservation2.setTown("Wroc³aw");
	        reservation2.setEmail("uuu@wp.pl");
	        reservation2.setPhone(346788887);
	        reservation2.setPostalCode("33-667");
	        reservation2.setDateOFReceipt(Date.valueOf("2020-12-15"));
	        reservation2.setDateOFReturn(Date.valueOf("2020-12-21"));
	        
	        Car car=new Car();
	        
	        car.setCarName("Toyota Avensis");
	        car.setPrice(350);
	        
	        City city1=new City();
	        
	        city1.setCityName("Kraków");

	        City city2=new City();
	        
	        city2.setCityName("Wroc³aw");
	        
	        CarRentalDao carRentalDao=new CarRentalDao();
	        carRentalDao.insertReservation(reservation1, car, city1);
	        carRentalDao.insertReservation(reservation2, car, city2);
	}

}
