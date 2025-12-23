package com.vishnu.resumeGen.controller;

import com.vishnu.resumeGen.model.UserDetails;
import com.vishnu.resumeGen.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class HomeController {
    @Value("${spring.application.name}")
    private String appName;

    private UserDetailsService userDetailsService;

    public HomeController(UserDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
    }
    @PostMapping("/")
    public UserDetails userDetailsService(@RequestBody UserDetails userDetails){
        return userDetailsService.saveUser(userDetails);
    }

}
