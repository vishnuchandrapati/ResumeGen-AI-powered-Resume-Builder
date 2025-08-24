package com.vishnu.resumeGen.controller;

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
    public ResponseEntity<String> getResponse(@RequestBody String response) {
        return ResponseEntity.ok(response);
    }
}
