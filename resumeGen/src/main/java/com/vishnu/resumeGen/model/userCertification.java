package com.vishnu.resumeGen.model;


import jakarta.persistence.*;

@Entity
public class userCertification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cer_id;
    private String certificateName;
    private String certificateProvider;
    private String certificateUrl;
    private String validityDate;
    private String licenceNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_mail", referencedColumnName = "userMail") // FK column in user_certification table
    private UserDetails userDetails;
    public userCertification() {
    }



    public userCertification(String certificateName, String certificateProvider, String certificateUrl, String validityDate, String licenceNumber) {
        this.certificateName = certificateName;
        this.certificateProvider = certificateProvider;
        this.certificateUrl = certificateUrl;
        this.validityDate = validityDate;
        this.licenceNumber = licenceNumber;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateProvider() {
        return certificateProvider;
    }

    public void setCertificateProvider(String certificateProvider) {
        this.certificateProvider = certificateProvider;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
