package com.vishnu.resumeGen.service;

import com.vishnu.resumeGen.model.userProject;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private ChatClient chatClient;

    public UserService(OllamaChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

    public String enhancedDescription(userProject project){
        String prompts = chatClient.prompt( "Rewrite the following project description to improve its ATS score. " +
               project.getProjectDescription()).toString();

        String response = chatClient.prompt( "Rewrite the following project description in 3 bullet points for resume to improve its ATS score. " +
                        "Do NOT show any thinking steps or explanations. Only output the final improved description."  +
                        project.getProjectDescription())
                .call()
                .content();
        System.out.println(prompts);
        return response;
    }




}
