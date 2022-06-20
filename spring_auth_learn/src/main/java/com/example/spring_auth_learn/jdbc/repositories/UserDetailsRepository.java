package com.example.spring_auth_learn.jdbc.repositories;

import com.example.spring_auth_learn.jdbc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
