package com.carrental.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.carrental.dao.CarRentalDao;
import com.carrental.model.Car;
import com.carrental.model.City;
import com.carrental.model.Reservation;

@Controller
public class HomeController {
	
	@Autowired
    private JavaMailSender mailSender;
	
	private CarRentalDao carRentalDao=new CarRentalDao();

	@RequestMapping(value="/")
	public ModelAndView home(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/AutoExecuter", method = RequestMethod.POST)
	public ModelAndView saveReservation(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		Reservation reservation= new Reservation();
		reservation.setFirstName(request.getParameter("firstName"));
		reservation.setLastName(request.getParameter("lastName"));
		reservation.setEmail(request.getParameter("email"));
		reservation.setPhone(Integer.parseInt(request.getParameter("phone")));
		reservation.setAddress(request.getParameter("address"));
		reservation.setTown(request.getParameter("town"));
		reservation.setAge(Integer.parseInt(request.getParameter("age")));
		reservation.setPostalCode(request.getParameter("postalCode"));
		
		reservation.setDateOFReceipt(Date.valueOf( request.getParameter("dateOfReceipt")));
        reservation.setDateOFReturn(Date.valueOf(request.getParameter("dateOfReturn")));
		
        Car car=new Car();
        car.setCarName(request.getParameter("carName"));
        car.setPrice(Float.parseFloat(request.getParameter("price")));
         City city=new City();
        city.setCityName(request.getParameter("cityName"));
        
        carRentalDao.insertReservation(reservation, car, city);
        
       
		return new ModelAndView("confirmation");
	}
	
	@RequestMapping(value = "/AvailabilityChecker",method = RequestMethod.POST)
	public @ResponseBody List<Car> checkAvailabilityOfCar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		List<Car> cars;
		Date dateOfReceipt =Date.valueOf( request.getParameter("dateOfReceipt"));
		Date dateOfReturn = Date.valueOf(request.getParameter("dateOfReturn"));
		String selectPlace = request.getParameter("selectPlace");
		cars=carRentalDao.checkAvailabilityOfCar(dateOfReceipt, dateOfReturn, selectPlace);
		
		return cars;
	}
	
	@RequestMapping(value = "/SelectedCar",method = RequestMethod.POST)
	public ModelAndView displayFormForSelectedCar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		Date dateOfReceipt =Date.valueOf( request.getParameter("dateOfReceipt"));
		Date dateOfReturn = Date.valueOf(request.getParameter("dateOfReturn"));
		String selectPlace = request.getParameter("selectPlace");
		String carName = request.getParameter("carName");
		Float price = Float.parseFloat(request.getParameter("price"));
		
		Car car=new Car();
		car.setCarName(carName);
		car.setPrice(price);
		City city=new City();
		city.setCityName(selectPlace);
		Reservation reservation=new Reservation();
		reservation.setDateOFReceipt(dateOfReceipt);
		reservation.setDateOFReturn(dateOfReturn);
		
		ModelAndView model = new ModelAndView("reservation");
		model.addObject("car", car);
		model.addObject("city", city);
		model.addObject("reservation", reservation);
		
		
		return model;
	}
	
	@RequestMapping(value = "/SendMessage",method = RequestMethod.POST)
	public ModelAndView sendMessage(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String to="ruszkow11@wp.pl";
		
		String contactName = request.getParameter("contactName");
		String contactEmail = request.getParameter("contactEmail");
		String contactSubject = request.getParameter("contactSubject");
		String contactMessage = request.getParameter("contactMessage");
		
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom(contactEmail);
        message.setSubject(contactSubject);
        message.setText(contactMessage);
        mailSender.send(message);
		
		
		ModelAndView model = new ModelAndView("confirmationemail");
		model.addObject("contactName", contactName);
		
		
		return model;
	}
	
	
	
	
	
	
}