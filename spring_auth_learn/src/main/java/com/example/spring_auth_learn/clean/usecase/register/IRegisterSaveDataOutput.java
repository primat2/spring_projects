package com.example.spring_auth_learn.clean.usecase.register;

import com.example.spring_auth_learn.clean.usecase.responseModel.RegisterDBSaveModel;


public interface IRegisterSaveDataOutput {
    boolean existsByName(String identifier);

    void save(RegisterDBSaveModel requestModel);
}
