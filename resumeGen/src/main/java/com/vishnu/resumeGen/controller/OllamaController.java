package com.vishnu.resumeGen.controller;

import com.vishnu.resumeGen.model.UserDetails;
import com.vishnu.resumeGen.model.userProject;
import com.vishnu.resumeGen.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai-enabled")
public class OllamaController {

    private final UserService userService;

    public OllamaController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/Ollama")
    public ResponseEntity<UserDetails> getResponse(@RequestBody UserDetails userDetails) {
        UserDetails aiResponce = userService.autoSaveandAutoEnhancedDescription(userDetails);
        return ResponseEntity.ok(aiResponce);
    }
}
