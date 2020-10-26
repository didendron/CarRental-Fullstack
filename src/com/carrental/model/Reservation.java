package com.carrental.model;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "reservations")
public class Reservation {
	
	 private Car car;
	 private City city;
	
	 @Id
	 @Column(name = "reservation_id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @Column()
	 private Date dateOFReceipt;
	 
	 @Column()
	 private Date dateOFReturn;
	 
	 @Column(length = 512, nullable = true)
	 private String firstName;
	 
	 @Column(length = 512, nullable = true)
	 private String lastName;
	 
	 @Column(length = 512, nullable = true)
	 private String email;
	 
	 @Column(nullable=true)
	 private Integer phone;
	 
	 @Column(length = 512, nullable = true)
	 private String address;
	 
	 @Column(length = 512, nullable = true)
	 private String town;
	 
	 @Column(nullable=true)
	 private Integer age;
	 
	 @Column(length = 512, nullable = true)
	 private String postalCode;
	 
	 @Access(AccessType.PROPERTY)
	 @ManyToOne
	 @JoinColumn(name = "car_id")
	 public Car getCar() {
	        return car;
	 }
	 
	 @Access(AccessType.PROPERTY)
	 @ManyToOne
	 @JoinColumn(name = "city_id")
	 public City getCity() {
	        return city;
	 }


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Date getDateOFReceipt() {
		return dateOFReceipt;
	}

	public void setDateOFReceipt(Date dateOFReceipt) {
		this.dateOFReceipt = dateOFReceipt;
	}

	public Date getDateOFReturn() {
		return dateOFReturn;
	}

	public void setDateOFReturn(Date dateOFReturn) {
		this.dateOFReturn = dateOFReturn;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public void setCity(City city) {
		this.city = city;
	}

	
	
	 
	 





}
