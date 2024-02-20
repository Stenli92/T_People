package com.example.demo.domain.models;

import com.example.demo.domain.entities.T_People;

public class MailModel {

    private String EMAIL_TYPE;
    private String EMAIL;

    public MailModel(String EMAIL_TYPE, String EMAIL) {
        this.EMAIL_TYPE = EMAIL_TYPE;
        this.EMAIL = EMAIL;
    }



    public String getEMAIL_TYPE() {
        return EMAIL_TYPE;
    }

    public void setEMAIL_TYPE(String EMAIL_TYPE) {
        this.EMAIL_TYPE = EMAIL_TYPE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

}
