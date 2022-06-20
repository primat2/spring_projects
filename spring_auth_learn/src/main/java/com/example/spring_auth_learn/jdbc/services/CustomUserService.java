package com.example.spring_auth_learn.jdbc.services;

import com.example.spring_auth_learn.jdbc.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userDetailsRepository.findByUserName(username);

        if (user == null){
            throw new UsernameNotFoundException("Not found user with username: " + username);
        }
        return user;
    }
}
