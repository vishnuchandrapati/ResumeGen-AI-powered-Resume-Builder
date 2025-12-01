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

    private final UserLoginService userLoginService;

    public LoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLoginService(@RequestBody UserLogin userLogin){
        if(!userLoginService.checkRegistrationRepo(userLogin) || !userLoginService.passwordChecker(userLogin)){
            return ResponseEntity.status(404).body("User not found or incorrect password");
        }
        return ResponseEntity.ok("Logged In successfully");
    }
}
