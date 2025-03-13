package com.fleet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.Entity.Route;
import com.fleet.Repositories.RouteRepository;


@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;

    public Route addRoute(Route route) {
        return routeRepository.save(route);
    }

    public Route getRoute(Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}