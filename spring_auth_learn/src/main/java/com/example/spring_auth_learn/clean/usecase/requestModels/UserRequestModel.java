package com.example.spring_auth_learn.clean.usecase.requestModels;

public class UserRequestModel {

    String name;
    String password;

    public UserRequestModel() {
        super();
    }

    UserRequestModel(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }
}
