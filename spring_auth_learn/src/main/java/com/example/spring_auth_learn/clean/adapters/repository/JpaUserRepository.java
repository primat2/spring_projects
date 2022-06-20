package com.example.spring_auth_learn.clean.adapters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface JpaUserRepository extends JpaRepository<UserDataMapper, String> {
}
