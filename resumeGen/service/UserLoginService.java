package com.vishnu.resumeGen.service;

import com.vishnu.resumeGen.model.UserLogin;

import com.vishnu.resumeGen.repository.LoginRepo;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    private final LoginRepo loginRepo;

    public UserLoginService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }


    public UserLogin saveLoginDetails(UserLogin userLogin){
        return loginRepo.save(userLogin);
    }
}

