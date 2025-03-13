package com.fleet.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fleet.Repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from the database
        com.fleet.Entity.User customUser = userRepository.findByUsername(username);
        if (customUser == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Ensure roles are prefixed with ROLE_
        String role = customUser.getRole();
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }

        // Build and return Spring Security's User object
        return User.withUsername(customUser.getUsername())
                   .password(customUser.getPassword()) // Ensure this is BCrypt encoded
                   .roles(role.replace("ROLE_", "")) // Remove the prefix for Spring Security's internal usage
                   .build();
    }
}
