package com.vishnu.resumeGen.service;

import com.vishnu.resumeGen.model.UserDetails;
import com.vishnu.resumeGen.model.UserEducation;
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

        if(userDetails.getUserEducationList()!=null){
            userDetails.getUserEducationList().forEach(edu -> edu.setUserDetails(userDetails));
        }
        if(userDetails.getUserExperienceList()!=null){
            userDetails.getUserExperienceList().forEach(exp -> exp.setUserDetails(userDetails));
        }
        if(userDetails.getUserCertificationList()!=null){
            userDetails.getUserCertificationList().forEach(cert -> cert.setUserDetails(userDetails));
        }
        if(userDetails.getUserProjectsList()!=null){
            for(userProject project1 : userDetails.getUserProjectsList()){
                String userDesc = project1.getProjectDescription();
                try {
                    String enhancedDesc = chatClient.prompt("Rewrite the following project description as 3 concise bullet points\n" +
                                    "            suitable for a software engineer resume to improve its ATS score.\n" +
                                    "            - Use strong action verbs.\n" +
                                    "            - Include measurable impact where possible.\n" +
                                    "            - Keep it ATS-friendly (simple formatting, no tables, no emojis).\n" +
                                    "            - Do NOT show any thinking steps or explanations.\n" +
                                    "            Only output the final improved bullet points.\n" +
                                    "\n" +
                                    "            Project description:" +
                                    userDesc)
                            .call()
                            .content();
                    project1.setProjectDescription(enhancedDesc);
                }
                catch(Exception e){
                    System.err.println("AI failed to load" + e.getMessage());
                    project1.setProjectDescription(userDesc);
                }
                project1.setUserDetails(userDetails);
            }
        }

        return userRepo.save(userDetails);
    }




}
