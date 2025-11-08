package com.vishnu.resumeGen.controller;

import com.vishnu.resumeGen.model.UserDetails;
import com.vishnu.resumeGen.model.UserLogin;
import com.vishnu.resumeGen.service.UserDetailsService;
import com.vishnu.resumeGen.service.UserLoginService;
import com.vishnu.resumeGen.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class LoginController {

    //private final UserDetailsService userDetailsService;

    private final UserLoginService userLoginService;

    public LoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }


    //    public LoginController(UserDetailsService userDetailsService, UserLoginService userLoginService) {
//        this.userDetailsService = userDetailsService;
//        this.userLoginService = userLoginService;
//    }
    @PostMapping("/login")
    public ResponseEntity<UserLogin> userLogin(@RequestBody UserLogin userLogin){
        UserLogin savedLogin = userLoginService.saveLoginDetails((userLogin));
        return ResponseEntity.ok(savedLogin);
    }

//    @PostMapping("/userDetails")
//    public UserDetails createUser(@Valid @RequestBody UserDetails userDetails){
//        return userDetailsService.saveUser(userDetails);
//    }
//
//    @GetMapping("/userDetails")
//    public UserDetails getByName(@RequestParam String firstName){
//        return null;
//    }
}
