package com.cab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cab.dao.DriverRepository;
import com.cab.dto.LocationDto;
import com.cab.entity.Driver;
import com.cab.util.Status;


@RestController
@RequestMapping("/v1")
public class DriverController
{

   
	@Autowired
	private DriverRepository driverRepository;
	
	

	@PostMapping(path = "/drivers")
	public Driver addRider(@Valid @RequestBody Driver driver) {

		return driverRepository.save(driver);

	}

	
	@PutMapping(path = "/driver/{driverId}/location")
	public Driver updateLocation(@PathVariable(value = "driverId") Long driverId , @RequestBody LocationDto location) {

		Driver d1 = driverRepository.findById(driverId).get();
		d1.setLatitude(location.getLatitude());
		d1.setLongitude(location.getLongitude());
				
		return driverRepository.save(d1);

	}
	
	@PutMapping(path = "/driver/{driverId}/availability")
	public Driver updateAvailability(@PathVariable(value = "driverId") Long driverId , @RequestParam Status status) {

		Driver d1 = driverRepository.findById(driverId).get();
		d1.setStatus(status);
		
		return driverRepository.save(d1);

	}

	
}
