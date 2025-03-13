package com.fleet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleet.Entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
}

