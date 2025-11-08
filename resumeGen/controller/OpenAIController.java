package com.vishnu.resumeGen.controller;

import com.vishnu.resumeGen.model.userProject;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai-enabled")
public class OpenAIController {

    private ChatClient chatClient;

    public OpenAIController(OpenAiChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

    @PostMapping("/Chat-GPT")
    public ResponseEntity<String> getResponse(@RequestBody userProject userProject) {
        String response = chatClient.prompt("Change the project description to get good ATS score: " +
                        userProject.getProjectDescription())
                .call()
                .content();
        return ResponseEntity.ok(response);
    }
}
