package com.example.demo.domain.entities;


import jakarta.persistence.*;

@Entity
@Table
public class T_Mails extends  BaseEntity{

    private String EMAIL_TYPE;
    private String EMAIL;
    private T_People people;

    public T_Mails() {
    }


    public T_Mails(String EMAIL_TYPE, String EMAIL) {
        this.EMAIL_TYPE = EMAIL_TYPE;
        this.EMAIL = EMAIL;
    }

    @Column(nullable = false)
    public String getEMAIL_TYPE() {
        return EMAIL_TYPE;
    }

    public void setEMAIL_TYPE(String EMAIL_TYPE) {
        this.EMAIL_TYPE = EMAIL_TYPE;
    }

    @Column(nullable = false)
    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }


    @ManyToOne(targetEntity = T_People.class)
    @JoinColumn(name = "people_id" , referencedColumnName = "id" )
    public T_People getPeople() {
        return people;
    }

    public void setPeople(T_People people) {
        this.people = people;
    }
}
