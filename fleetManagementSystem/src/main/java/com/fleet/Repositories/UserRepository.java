package com.fleet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleet.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
