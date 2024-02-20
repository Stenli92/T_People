package com.example.demo.web.models;


import jakarta.validation.constraints.*;

public class PeopleServiceModel {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";



    @NotEmpty(message = "Full name cannot be empty")
    @Size(min = 8 , max = 90 , message = "Full name should contain between 8 and 90 symbols")
    private String fullName;


    @Size(min = 10 , max = 10 , message = "Pin should contain 10 symbols")
    private String pin;
    private String emailType;

    @Pattern(regexp = EMAIL_PATTERN , message = "Please insert a valid email pattern")
    private String email;

    @NotNull
    @NotEmpty(message = "Please insert address type!")
    private String addressType;

    @Size(min = 10 , max = 300 , message = "The address should contain between 10 and 300 symbols")
    private String addressInfo;

    public PeopleServiceModel() {
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }
}
