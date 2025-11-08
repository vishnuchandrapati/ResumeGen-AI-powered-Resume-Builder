package com.vishnu.resumeGen.controller;


import com.vishnu.resumeGen.model.UserRegistration;
import com.vishnu.resumeGen.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistration user) {
        if(user.getUserMail()==null || user.getUserMail().isEmpty()){
            return ResponseEntity.badRequest().body("Email must be provided");
        }
        registerService.registerNewUser(user.getUserMail(), user.getUserFirstName(), user.getUserLastName(), user.getPassword());
        return ResponseEntity.ok("User registered successfully!. Your password is " + user.getPassword() );

    }


}
