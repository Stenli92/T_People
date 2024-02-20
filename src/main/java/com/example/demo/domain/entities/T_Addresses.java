package com.example.demo.domain.entities;
import jakarta.persistence.*;


@Entity
@Table
public class T_Addresses extends BaseEntity{

    private String addrType;
    private String addrInfo;

    private T_People people;

    public T_Addresses( String addrType, String addrInfo) {
        this.addrType = addrType;
        this.addrInfo = addrInfo;
    }

    public T_Addresses() {
    }

    @ManyToOne(targetEntity = T_People.class)
    @JoinColumn(name = "people_id" , referencedColumnName = "id")
    public T_People getPeople() {
        return people;
    }

    public void setPeople(T_People people) {
        this.people = people;
    }

    @Column(nullable = false)
    public String getAddrType() {
        return addrType;
    }

    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }

    @Column(nullable = true )
    public String getAddrInfo() {
        return addrInfo;
    }

    public void setAddrInfo(String addrInfo) {
        this.addrInfo = addrInfo;
    }
}
