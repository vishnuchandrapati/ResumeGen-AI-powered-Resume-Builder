package com.vishnu.resumeGen.controller;

import com.vishnu.resumeGen.model.UserDetails;
import com.vishnu.resumeGen.repository.UserRepo;
import com.vishnu.resumeGen.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;
    private UserRepo userRepo;
    private UserDetailsService userDetailsService;

    public HomeController(UserRepo userRepo, UserDetailsService userDetailsService){
        this.userRepo = userRepo;
        this.userDetailsService = userDetailsService;
    }
    @GetMapping("/")
//    public UserDetails userDetailsService(@RequestBody UserDetails userDetails){
//        return userDetailsService.saveUser(userDetails);
//    }
    public UserDetails getAllUserDetails(@RequestParam String mail){

        return userRepo.findByUserMail(mail);
    }

}
