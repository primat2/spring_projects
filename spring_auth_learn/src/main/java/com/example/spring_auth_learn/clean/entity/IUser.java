package com.example.spring_auth_learn.clean.entity;



public interface IUser {
    boolean passwordIsValid();

    String getName();

    String getPassword();
}
