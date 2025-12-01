package com.vishnu.resumeGen.service;

import com.vishnu.resumeGen.model.*;
import com.vishnu.resumeGen.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserDetailsService {

    private final UserRepo userRepo;
    @Autowired
    public UserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



    public UserDetails saveUser(@RequestBody UserDetails userDetails){
        if (userDetails.getUserEducationList() != null) {
            for (userEducation edu : userDetails.getUserEducationList()) {
                edu.setUserDetails(userDetails);
            }
        }
        if (userDetails.getUserProjectsList() != null) {
            for (userProject proj : userDetails.getUserProjectsList()) {
                proj.setUserDetails(userDetails);
            }
        }

        if(userDetails.getUserCertificationList() != null){
            for(userCertification cert : userDetails.getUserCertificationList()){
                cert.setUserDetails(userDetails);
            }
        }

        if(userDetails.getUserExperienceList() != null){
            for(userExperience exp : userDetails.getUserExperienceList()){
                exp.setUserDetails(userDetails);
            }
        }
        return userRepo.save(userDetails);
    }

}
