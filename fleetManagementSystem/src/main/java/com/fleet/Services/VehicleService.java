package com.fleet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.Entity.Route;
import com.fleet.Entity.Vehicle;
import com.fleet.Repositories.RouteRepository;
import com.fleet.Repositories.VehicleRepository;


@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private RouteRepository routeRepository;

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicle(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

//    public Vehicle updateVehicle(Vehicle vehicle) {
//        return vehicleRepository.save(vehicle);
//    }
    
    public Vehicle updateVehicle(Vehicle vehicle) {
        // Fetch the existing vehicle by its ID
        Vehicle existingVehicle = vehicleRepository.findById(vehicle.getId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found with ID: " + vehicle.getId()));

        // Update fields of the existing vehicle
        existingVehicle.setModel(vehicle.getModel());
        existingVehicle.setLicensePlate(vehicle.getLicensePlate());
        existingVehicle.setFuelEfficiency(vehicle.getFuelEfficiency());

        // Save the updated vehicle
        return vehicleRepository.save(existingVehicle);
    }



    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle assignRouteToVehicle(Long vehicleId, Long routeId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        Route route = routeRepository.findById(routeId).orElseThrow(() -> new RuntimeException("Route not found"));
        vehicle.setRoute(route);
        return vehicleRepository.save(vehicle);
    }
}