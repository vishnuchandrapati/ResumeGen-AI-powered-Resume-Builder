package com.vishnu.resumeGen.model;


import jakarta.persistence.*;

@Entity
public class userExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exp_id;
    private String companyName;
    private String userRole;
    private int yearsOfExperience;
    private String userResponsibilities;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // FK column in user_certification table
    private UserDetails userDetails;
    public userExperience() {
    }

    public userExperience(String companyName, String userRole, int yearsOfExperience, String userResponsibilities) {
        this.companyName = companyName;
        this.userRole = userRole;
        this.yearsOfExperience = yearsOfExperience;
        this.userResponsibilities = userResponsibilities;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getUserResponsibilities() {
        return userResponsibilities;
    }

    public void setUserResponsibilities(String userResponsibilities) {
        this.userResponsibilities = userResponsibilities;
    }
}
