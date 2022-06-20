package com.example.spring_auth_learn.clean.adapters.repository;


import com.example.spring_auth_learn.clean.usecase.register.IRegisterSaveDataOutput;
import com.example.spring_auth_learn.clean.usecase.responseModel.RegisterDBSaveModel;


class RegisterUserDB implements IRegisterSaveDataOutput {

    final JpaUserRepository repository;

    RegisterUserDB(JpaUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsById(name);
    }

    @Override
    public void save(RegisterDBSaveModel requestModel) {
        UserDataMapper accountDataMapper = new UserDataMapper(requestModel.getName(), requestModel.getPassword(), requestModel.getCreationTime());
        repository.save(accountDataMapper);
    }
}
