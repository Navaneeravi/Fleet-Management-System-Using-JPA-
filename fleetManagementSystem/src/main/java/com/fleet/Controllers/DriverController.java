package com.fleet.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.Entity.Route;
import com.fleet.Entity.Vehicle;
import com.fleet.Services.VehicleService;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private VehicleService vehicleService;

    // Endpoint for drivers to view their assigned route
    @GetMapping("/vehicles/{vehicleId}/route")
    public Route getAssignedRoute(@PathVariable Long vehicleId) {
        Vehicle vehicle = vehicleService.getVehicle(vehicleId);
        if (vehicle != null && vehicle.getRoute() != null) {
            return vehicle.getRoute();
        }
        throw new RuntimeException("No route assigned to the vehicle or vehicle not found.");
    }
}
