package com.example.spring_auth_learn.clean.usecase.register;


import com.example.spring_auth_learn.clean.usecase.requestModels.UserRequestModel;
import com.example.spring_auth_learn.clean.usecase.responseModel.UserResponseModel;

public interface IRegisterInput {
    UserResponseModel create(UserRequestModel requestModel);
}
