package com.cab.controller;

import javax.validation.Valid;

import com.cab.dto.RideDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cab.dao.RiderRepository;
import com.cab.entity.Ride;
import com.cab.entity.Rider;
import com.cab.service.LocationService;

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
	public RideDetail findRide(@PathVariable(value = "riderId") Long riderId) {

		return locationService.findRide(riderId);
	}


}
