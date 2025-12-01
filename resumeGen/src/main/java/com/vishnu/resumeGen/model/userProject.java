package com.vishnu.resumeGen.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class userProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proj_id;
    private String projectName;
    private String projectDescription;

    private String projectTechStack;
    private String projectToolsUsed;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_mail", referencedColumnName = "userMail")
    private UserDetails userDetails;
    public userProject() {
    }

    public userProject(String projectName, String projectDescription, String projectTechStack, String projectToolsUsed, String projectGitHubLink) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectTechStack = projectTechStack;
        this.projectToolsUsed = projectToolsUsed;
        this.projectGitHubLink = projectGitHubLink;
    }


    private String projectGitHubLink;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectTechStack() {
        return projectTechStack;
    }

    public void setProjectTechStack(String projectTechStack) {
        this.projectTechStack = projectTechStack;
    }

    public String getProjectToolsUsed() {
        return projectToolsUsed;
    }

    public void setProjectToolsUsed(String projectToolsUsed) {
        this.projectToolsUsed = projectToolsUsed;
    }

    public String getProjectGitHubLink() {
        return projectGitHubLink;
    }

    public void setProjectGitHubLink(String projectGitHubLink) {
        this.projectGitHubLink = projectGitHubLink;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
