package com.vishnu.resumeGen.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "registered_users")
public class UserRegistration {

    @Id
    @Email
    @NotNull
    @Column(nullable = false, unique = true)
    private String userMail;
    @Column(nullable = false)
    private String userFirstName;
    @Column(nullable = false)
    private String userLastName;
    @Column(nullable = false)
    private String password;

    public UserRegistration(){};

    public UserRegistration(String userMail, String userFirstName, String userLastName, String password) {
        this.userMail = userMail;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.password = password;
    }
    public void setUserMail(String userMail){this.userMail = userMail;}
    public String getUserMail(){return userMail;}
    public void setUserFirstName(String userFirstName){this.userFirstName = userFirstName;}
    public String getUserFirstName(){return userFirstName;}
    public void setUserLastName(String userLastName){this.userLastName = userLastName;}
    public String getUserLastName(){return userLastName;}
    public void setPassword(String password){this.password = password;}
    public String getPassword(){return password;}

}
