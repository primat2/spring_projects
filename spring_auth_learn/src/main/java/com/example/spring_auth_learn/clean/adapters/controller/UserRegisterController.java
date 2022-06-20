package com.example.spring_auth_learn.clean.adapters.controller;

import com.example.spring_auth_learn.clean.usecase.register.IRegisterInput;
import com.example.spring_auth_learn.clean.usecase.requestModels.UserRequestModel;
import com.example.spring_auth_learn.clean.usecase.responseModel.UserResponseModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserRegisterController {

    final IRegisterInput userInput;

    UserRegisterController(IRegisterInput accountGateway) {
        this.userInput = accountGateway;
    }

    @PostMapping("/user")
    UserResponseModel create(@RequestBody UserRequestModel requestModel) {
        return this.userInput.create(requestModel);
    }
}
