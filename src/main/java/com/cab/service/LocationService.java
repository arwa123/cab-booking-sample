package com.cab.service;

import com.cab.dao.DriverRepository;
import com.cab.dao.RiderRepository;
import com.cab.dto.RideDetail;
import com.cab.entity.Driver;
import com.cab.entity.Rider;
import com.cab.util.DriverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.dto.LocationDto;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class LocationService {

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private RiderRepository riderRepository;
	
	public Double getDistance(LocationDto loc1, LocationDto loc2) {
		try {
			
			return Math.sqrt(Math.pow((loc1.getLatitude() - loc1.getLatitude()),2) + Math.pow((loc2.getLongitude() - loc1.getLongitude()),2));

		} catch (Exception ex) {
		}
		return null;

	}

	public RideDetail findRide(Long riderId) {

		Rider rider = riderRepository.findById(riderId).get();
		LocationDto riderLocation = rider.getLocation();
		List<Driver> drivers = driverRepository.findAll();

		 Map<Double, Driver> driverMap = drivers.stream().filter(driver -> driver.getDriverStatus() == DriverStatus.online).collect(Collectors.toMap(driver -> getDistance(riderLocation, driver.getLocation()), Function.identity()));
		Double smallestDistance = driverMap.keySet().stream().min(Double::compareTo).get();
		Driver nearestDriver = driverMap.get(smallestDistance);

		RideDetail ride = new RideDetail();
		ride.setDriverContact(nearestDriver.getContact());
		ride.setDriverName(nearestDriver.getName());
		ride.setDistance(smallestDistance);
		return ride;
	}

}
