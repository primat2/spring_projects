package com.example.spring_auth_learn.simple_auth;

import com.example.spring_auth_learn.jdbc.entities.Authority;
import com.example.spring_auth_learn.jdbc.entities.User;
import com.example.spring_auth_learn.jdbc.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringAuthLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAuthLearnApplication.class, args);
    }

}
