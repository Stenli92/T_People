package com.example.demo.domain.entities;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class T_People extends BaseEntity{


    private String fullName;
    private String pin;

    private List<T_Mails> mails;
    private List<T_Addresses> addresses;

    public T_People() {
    }

    @Column(nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(nullable = true, length = 10)
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @OneToMany(mappedBy = "people",cascade = CascadeType.ALL)
    public List<T_Mails> getMails() {
        return mails;
    }

    public void setMails(List<T_Mails> mails) {
        this.mails = mails;
    }

    @OneToMany(mappedBy = "people" , cascade = CascadeType.ALL)
    public List<T_Addresses> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<T_Addresses> addresses) {
        this.addresses = addresses;
    }


}
