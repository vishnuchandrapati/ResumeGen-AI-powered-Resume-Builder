package com.vishnu.resumeGen.service;

import com.vishnu.resumeGen.model.UserLogin;

import com.vishnu.resumeGen.model.UserRegistration;
import com.vishnu.resumeGen.repository.LoginRepo;
import com.vishnu.resumeGen.repository.RegistrationRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {

    private final RegistrationRepo registrationRepo;
    private final LoginRepo loginRepo;

    public UserLoginService(RegistrationRepo registrationRepo, LoginRepo loginRepo) {
        this.registrationRepo = registrationRepo;
        this.loginRepo = loginRepo;
    }
    public boolean checkRegistrationRepo(UserLogin userLogin){
        String userMail = userLogin.getUserMail();

        if(!registrationRepo.existsByUserMail(userMail)){
            return false;
        }
        loginRepo.save(userLogin);
        return true;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    public boolean passwordChecker(UserLogin userLogin){
        UserRegistration userReg = registrationRepo.findByUserMail(userLogin.getUserMail());
        if(userReg==null) return false;

        return passwordEncoder.matches(userLogin.getPassword(), userReg.getPassword());
    }
}

