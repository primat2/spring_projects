package com.example.spring_auth_learn.clean.entity;


class CommonIUserFactory implements IUserFactory {
    @Override
    public IUser create(String name, String password) {
        return new CommonIUser(name, password);
    }
}
