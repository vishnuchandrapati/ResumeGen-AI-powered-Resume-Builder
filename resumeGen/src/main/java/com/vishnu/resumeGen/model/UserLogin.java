package com.vishnu.resumeGen.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class UserLogin {
    @Id
    @NotNull
    private String userMail;
    private String password;


    public UserLogin() {
    }
    public UserLogin(String userMail, String password) {
        this.userMail = userMail;
        this.password = password;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
