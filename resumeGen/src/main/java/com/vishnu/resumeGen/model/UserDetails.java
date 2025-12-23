package com.vishnu.resumeGen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int userAge;
    @Email
    @Column(unique = true, nullable = false)
    private String userMail;
    @Pattern(regexp = "\\d{10}", message = "Mobile Number must be 10 digits")
    private String mobileNumber;
    private String userLocation;
    private String linkedInUrl;
    private String gitHubUrl;
    private String otherUrl;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<userEducation> userEducationList;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<userProject> userProjectsList;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<userExperience> userExperienceList;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<userCertification> userCertificationList;

    public UserDetails() {
    }

    public UserDetails(String firstName, String lastName, int userAge, String userMail, String mobileNumber, String userLocation, String linkedInUrl, String gitHubUrl, String otherUrl, List<userEducation> userEducationList, List<userProject> userProjectsList, List<userExperience> userExperienceList, List<userCertification> userCertificationList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAge = userAge;
        this.userMail = userMail;
        this.mobileNumber = mobileNumber;
        this.userLocation = userLocation;
        this.linkedInUrl = linkedInUrl;
        this.gitHubUrl = gitHubUrl;
        this.otherUrl = otherUrl;
        this.userEducationList = userEducationList;
        this.userProjectsList = userProjectsList;
        this.userExperienceList = userExperienceList;
        this.userCertificationList = userCertificationList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public String getFullName() {
        return (firstName != null ? firstName : "") +
                " " +
                (lastName != null ? lastName : "");
    }


    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {

        this.userMail = userMail;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public String getGitHubUrl() {
        return gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    public String getOtherUrl() {
        return otherUrl;
    }

    public void setOtherUrl(String otherUrl) {
        this.otherUrl = otherUrl;
    }

    public List<userEducation> getUserEducationList() {
        return userEducationList;
    }

    public void setUserEducationList(List<userEducation> userEducationList) {
        this.userEducationList = userEducationList;
    }

    public List<userProject> getUserProjectsList() {
        return userProjectsList;
    }

    public void setUserProjectsList(List<userProject> userProjectsList) {
        this.userProjectsList = userProjectsList;
    }

    public List<userExperience> getUserExperienceList() {
        return userExperienceList;
    }

    public void setUserExperienceList(List<userExperience> userExperienceList) {
        this.userExperienceList = userExperienceList;
    }

    public List<userCertification> getUserCertificationList() {
        return userCertificationList;
    }

    public void setUserCertificationList(List<userCertification> userCertificationList) {
        this.userCertificationList = userCertificationList;
    }
}
