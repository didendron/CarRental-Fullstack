package com.carrental.test;

import java.sql.Date;
import java.util.List;
import org.junit.Test;

import com.carrental.dao.CarRentalDao;
import com.carrental.model.Car;

public class CheckAvaibilityOfCarTest {
	
	@Test
	public void Test() {
		CarRentalDao carRentalDao=new CarRentalDao();
		List<Car> cars=carRentalDao.checkAvailabilityOfCar(Date.valueOf("2020-12-16"),
				Date.valueOf("2020-12-22"),"Wroc³aw");
		
		for(Car car:cars) {
			System.out.println(car.getCarName());
		}
		
	}

}
