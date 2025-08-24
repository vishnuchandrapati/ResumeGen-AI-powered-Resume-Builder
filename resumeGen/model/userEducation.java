package com.vishnu.resumeGen.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class userEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long edu_id;
    private String collegeName;
    private String userDegree;
    private String userBranch;
    private int graduationYear;
    private String userCgpa;

    public userEducation() {
    }

    public userEducation(String collegeName, String userDegree, String userBranch, int graduationYear, String userCgpa) {
        this.collegeName = collegeName;
        this.userDegree = userDegree;
        this.userBranch = userBranch;
        this.graduationYear = graduationYear;
        this.userCgpa = userCgpa;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getUserDegree() {
        return userDegree;
    }

    public void setUserDegree(String userDegree) {
        this.userDegree = userDegree;
    }

    public String getUserBranch() {
        return userBranch;
    }

    public void setUserBranch(String userBranch) {
        this.userBranch = userBranch;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getUserCgpa() {
        return userCgpa;
    }

    public void setUserCgpa(String userCgpa) {
        this.userCgpa = userCgpa;
    }

}


