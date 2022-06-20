package com.example.spring_auth_learn.clean.usecase.register;

import com.example.spring_auth_learn.clean.entity.IUser;
import com.example.spring_auth_learn.clean.entity.IUserFactory;
import com.example.spring_auth_learn.clean.usecase.responseModel.RegisterDBSaveModel;
import com.example.spring_auth_learn.clean.usecase.requestModels.UserRequestModel;
import com.example.spring_auth_learn.clean.usecase.responseModel.UserResponseModel;


import java.time.LocalDateTime;


class RegisterInteractor implements IRegisterInput {

    final IRegisterSaveDataOutput saveDataOutput;
    final IRegisterPresentDataOutput userPresenter;
    final IUserFactory userFactory;

    RegisterInteractor(IRegisterSaveDataOutput userRegisterDfGateway, IRegisterPresentDataOutput userPresenter,
                       IUserFactory userFactory) {
        this.saveDataOutput = userRegisterDfGateway;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    @Override
    public UserResponseModel create(UserRequestModel requestModel) {
        if (saveDataOutput.existsByName(requestModel.getName())) {
            return userPresenter.prepareFailView("User already exists.");
        }
        IUser user = userFactory.create(requestModel.getName(), requestModel.getPassword());
        if (!user.passwordIsValid()) {
            return userPresenter.prepareFailView("User password must have more than 5 characters.");
        }
        LocalDateTime now = LocalDateTime.now();

        saveDataOutput.save(
                new RegisterDBSaveModel(
                        user.getName(),
                        user.getPassword(),
                        now)
        );

        return userPresenter.prepareSuccessView(
                new UserResponseModel(
                        user.getName(),
                        now.toString())
        );
    }
}