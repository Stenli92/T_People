package com.example.demo.domain.models;

import com.example.demo.domain.entities.T_Addresses;
import com.example.demo.domain.entities.T_Mails;

import java.util.List;

public class PeopleModel {

    private String id;
    private String fullName;
    private String pin;
    private String mail;
    private String mailType;

    private String addrType;
    private String addrInfo;

    public PeopleModel() {
    }


    public PeopleModel(String id, String fullName, String pin, String mail, String mailType, String addrType, String addrInfo) {
        this.id = id;
        this.fullName = fullName;
        this.pin = pin;
        this.mail = mail;
        this.mailType = mailType;
        this.addrType = addrType;
        this.addrInfo = addrInfo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    public String getAddrType() {
        return addrType;
    }

    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }

    public String getAddrInfo() {
        return addrInfo;
    }

    public void setAddrInfo(String addrInfo) {
        this.addrInfo = addrInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
