package com.vishnu.resumeGen.service;

import com.vishnu.resumeGen.model.UserDetails;
import com.vishnu.resumeGen.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService {

    private final UserRepo userRepo;

    public UserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserDetails saveUser(UserDetails userDetails){
        return userRepo.save(userDetails);
    }

    public Optional<UserDetails> getUserByName(String firstName){
        return Optional.ofNullable(userRepo.findByFirstNameIgnoreCase(firstName));
    }
}
