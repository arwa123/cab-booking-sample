package com.cab.entity;

import javax.persistence.*;

import com.cab.dto.LocationDto;
import com.cab.util.DriverStatus;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "driver")
@Getter
@Setter
public class Driver   {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	Long id;
	
	@Column(name = "name")	
	String name;

	@Column(name = "contact")
	String contact;

	@Embedded
	LocationDto location;
	
	@Column(name = "status")
	DriverStatus driverStatus;

	@Column(name = "max_radius")
	Integer maxRadius;



}
