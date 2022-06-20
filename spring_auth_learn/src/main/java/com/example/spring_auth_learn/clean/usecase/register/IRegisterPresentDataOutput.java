package com.example.spring_auth_learn.clean.usecase.register;

import com.example.spring_auth_learn.clean.usecase.responseModel.UserResponseModel;

public interface IRegisterPresentDataOutput {
    UserResponseModel prepareSuccessView(UserResponseModel user);

    UserResponseModel prepareFailView(String error);
}
