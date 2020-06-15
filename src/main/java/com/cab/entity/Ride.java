package com.cab.entity;

import java.util.Date;

import javax.persistence.*;

import com.cab.dto.LocationDto;
import com.cab.util.RideStatus;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ride")
@Getter
@Setter
public class Ride {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	Long id;
	
	@Column(name = "user_id")	
	Long userId;
	
	@Column(name = "driver_id")	
	Long driverId; 

	@Embedded
	@Column(name = "destination")
	LocationDto destination;

	@Column(name = "status")
	RideStatus status = RideStatus.awaiting;
	
	@Column(name = "start_time")
	Date startTime = new Date();

	@Column(name = "end_time")
	Date endTime;


}
