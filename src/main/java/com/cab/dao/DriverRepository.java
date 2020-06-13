package com.cab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.entity.Driver;


@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
