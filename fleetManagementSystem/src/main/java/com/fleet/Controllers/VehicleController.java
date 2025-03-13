package com.fleet.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.Entity.Route;
import com.fleet.Entity.Vehicle;
import com.fleet.Services.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @GetMapping("/{id}")
    public Vehicle getVehicle(@PathVariable Long id) {
        return vehicleService.getVehicle(id);
    }

//    @PutMapping("/update")
//    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
//        return vehicleService.updateVehicle(vehicle);
//    }
    
    @PutMapping("/update/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        // Set the ID in the vehicle object before updating
        vehicle.setId(id);
        return vehicleService.updateVehicle(vehicle);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }

    @GetMapping("/")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // Endpoint to assign a route to a vehicle (accessible only to Admins)
    @PutMapping("/{vehicleId}/assignRoute/{routeId}")
    public Vehicle assignRouteToVehicle(@PathVariable Long vehicleId, @PathVariable Long routeId) {
        return vehicleService.assignRouteToVehicle(vehicleId, routeId);
    }

    // New endpoint to get the route assigned to a specific vehicle (accessible to Drivers)
    @GetMapping("/{vehicleId}/route")
    public Route getAssignedRoute(@PathVariable Long vehicleId) {
        Vehicle vehicle = vehicleService.getVehicle(vehicleId);
        if (vehicle != null && vehicle.getRoute() != null) {
            return vehicle.getRoute();
        }
        return null; // You can handle this differently based on your use case
    }
}