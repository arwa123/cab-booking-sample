package com.cab.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cab.entity.Driver;
import com.cab.entity.Rider;

public interface RiderRepository extends JpaRepository<Rider, Long> {


}
