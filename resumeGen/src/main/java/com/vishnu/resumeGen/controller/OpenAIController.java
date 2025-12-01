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
        String response = chatClient.prompt("Improve it to sound more professional, concise, and impact-driven. " +
                        "Use strong action verbs, quantify achievements where possible, and ensure the tone is suitable for a fresher applying for software development roles. " +
                        "Do not change the actual meaning of the content. Make the sentences clear, ATS-friendly, and aligned with industry standards." +
                        " After refining, present the final result in a clean paragraph format and give less than 255 characters. Here is my content: " +
                        userProject.getProjectDescription())
                .call()
                .content();
        return ResponseEntity.ok(response);
    }
}
