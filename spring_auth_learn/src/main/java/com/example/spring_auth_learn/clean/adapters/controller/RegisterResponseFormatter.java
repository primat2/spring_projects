package com.example.spring_auth_learn.clean.adapters.controller;

import com.example.spring_auth_learn.clean.usecase.register.IRegisterPresentDataOutput;
import com.example.spring_auth_learn.clean.usecase.responseModel.UserResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class RegisterResponseFormatter implements IRegisterPresentDataOutput {

    @Override
    public UserResponseModel prepareSuccessView(UserResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public UserResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
