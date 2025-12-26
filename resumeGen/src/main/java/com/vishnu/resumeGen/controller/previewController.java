package com.vishnu.resumeGen.controller;

import com.vishnu.resumeGen.model.UserDetails;
import com.vishnu.resumeGen.repository.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class previewController{

    private UserRepo userRepo;

    public previewController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/resume")
public String loadResumeAfterLogin(
        @RequestParam String mail, Model model) {

    UserDetails user = userRepo.findByUserMail(mail);

    if (user == null) {
        model.addAttribute("user", new UserDetails());
        return "resume-template";
    }

    model.addAttribute("user", user);
    return "resume"; // preview existing resume
}

}
