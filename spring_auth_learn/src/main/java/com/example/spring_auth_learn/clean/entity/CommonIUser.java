package com.example.spring_auth_learn.clean.entity;

class CommonIUser implements IUser {

    String name;
    String password;

    CommonIUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    CommonIUser() {
    }

    @Override
    public boolean passwordIsValid() {
        return password != null && password.length() > 5;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
