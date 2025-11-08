package com.vishnu.resumeGen.service;

import com.vishnu.resumeGen.model.UserRegistration;
import com.vishnu.resumeGen.repository.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    
    private final RegistrationRepo registrationRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(RegistrationRepo registrationRepo, PasswordEncoder passwordEncoder) {
        this.registrationRepo = registrationRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public UserRegistration registerNewUser(String userMail, String userFirstName, String userLastName, String password){
        if(registrationRepo.existsByUserMail(userMail)){
            throw new RuntimeException("User already exists");
        }
        UserRegistration user = new UserRegistration(userMail, userFirstName, userLastName, passwordEncoder.encode(password));
        return registrationRepo.save(user);
    }

}
