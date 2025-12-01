package com.vishnu.resumeGen.service;

import com.vishnu.resumeGen.model.UserDetails;
import com.vishnu.resumeGen.model.userProject;
import com.vishnu.resumeGen.repository.UserRepo;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    private final UserRepo userRepo;
    private ChatClient chatClient;


    public UserService(UserRepo userRepo, OllamaChatModel chatModel) {

        this.userRepo = userRepo;
        this.chatClient = ChatClient.create(chatModel);
    }

    public UserDetails autoSaveandAutoEnhancedDescription(UserDetails userDetails){

        if(userDetails.getUserProjectsList()!=null){
            for(userProject project1 : userDetails.getUserProjectsList()){
                String userDesc = project1.getProjectDescription();
                String enhancedDesc = chatClient.prompt( "Rewrite the following project description in 3 bullet points for resume to improve its ATS score. " +
                                "Do NOT show any thinking steps or explanations. Only output the final improved description."  +
                                userDesc)
                        .call()
                        .content();
                project1.setProjectDescription(enhancedDesc);
                project1.setUserDetails(userDetails);
            }
        }

        return userRepo.save(userDetails);
    }




}
