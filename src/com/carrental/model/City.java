package com.carrental.model;

import java.util.*;


import javax.persistence.*;



@Entity
@Table(name = "cities")
public class City {
	
	 private Set<Reservation> reservations;
	
	 @Id
	 @Column(name = "city_id")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 
	 @Column(length = 512, nullable = false)
	 private String cityName;
	 
	 @Access(AccessType.PROPERTY)
	 @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
	 public Set<Reservation> getReservations() {
	        return reservations;
	 }
	 
	 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	
	 
}
