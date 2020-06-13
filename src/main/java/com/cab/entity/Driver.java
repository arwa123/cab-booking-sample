package com.cab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cab.util.Status;

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
	
	@Column(name = "latitude")	
	Double latitude;
	
	@Column(name = "longitude")	
	Double longitude;
	
	@Column(name = "status")	
	Status status;

	
	
}
