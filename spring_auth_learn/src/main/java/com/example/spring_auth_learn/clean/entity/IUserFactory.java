package com.example.spring_auth_learn.clean.entity;

public interface IUserFactory {
    IUser create(String name, String password);
}
