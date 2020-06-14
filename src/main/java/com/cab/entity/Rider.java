package com.cab.entity;

import javax.persistence.*;

import com.cab.dto.LocationDto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rider")
@Getter
@Setter
public class Rider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	Long id;
	
	@Column(name = "name")	
	String name;

	@Embedded
	LocationDto location;

}
