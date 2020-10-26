package com.carrental.model;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "cars")
public class Car {
	
	 
	 private Set<Reservation> reservations;
	
	 @Id
	 @Column(name = "car_id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @Column(length = 512, nullable = false)
	 private String carName;
	 
	 @Column( precision = 10, scale = 2)
	 private float price;
	 
	 
	 
	 @Access(AccessType.PROPERTY)
	 @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
	 @JsonIgnore
	 public Set<Reservation> getReservations() {
	        return reservations;
	 }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	 
	 

}
