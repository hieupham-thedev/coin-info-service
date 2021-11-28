package com.example.coininfoservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Sample user for admin role
        User user = new User("admin", passwordEncoder.encode("admin"), AuthorityUtils.NO_AUTHORITIES);

        // Found user or not
        if (!user.getUsername().equals(username)) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return user;
        }
    }

}
