package com.fleet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleet.Entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}

