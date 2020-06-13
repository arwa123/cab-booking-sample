package com.cab.service;

import org.springframework.stereotype.Service;

import com.cab.dto.LocationDto;
import com.cab.entity.Ride;


@Service
public class LocationService {
	
	
	public Double getDistance(LocationDto loc1, LocationDto loc2) {
		try {
			
			return Math.sqrt(Math.pow((loc1.getLatitude() - loc1.getLatitude()),2) + Math.pow((loc2.getLongitude() - loc1.getLongitude()),2));

		} catch (Exception ex) {
		}
		return null;

	}

	public Ride findRide(Long driverId) {
		
		return null;
	}

}
