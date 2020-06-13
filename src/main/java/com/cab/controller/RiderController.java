package com.cab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cab.dao.RiderRepository;
import com.cab.entity.Driver;
import com.cab.entity.Ride;
import com.cab.entity.Rider;
import com.cab.service.LocationService;
import com.cab.util.Status;

@RestController
@RequestMapping("/v1")
public class RiderController {

	@Autowired
	private RiderRepository riderRepository;
	
	@Autowired
	private LocationService locationService;

	@PostMapping(path = "/riders")
	public Rider addRider(@Valid @RequestBody Rider rider) {

		return riderRepository.save(rider);

	}
	
	
	@GetMapping(path = "/rider/{riderId}/ride")
	public Ride findRide(@PathVariable(value = "riderId") Long driverId) {

		return locationService.findRide(driverId);
	}


}
