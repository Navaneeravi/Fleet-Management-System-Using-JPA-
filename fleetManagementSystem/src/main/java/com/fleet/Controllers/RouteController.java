package com.fleet.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleet.Entity.Route;
import com.fleet.Services.RouteService;


@RestController
@RequestMapping("/routes")
public class RouteController {
    @Autowired
    private RouteService routeService;

    @PostMapping("/add")
    public Route addRoute(@RequestBody Route route) {
        return routeService.addRoute(route);
    }

    @GetMapping("/{id}")
    public Route getRoute(@PathVariable Long id) {
        return routeService.getRoute(id);
    }

    @GetMapping("/")
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }
}