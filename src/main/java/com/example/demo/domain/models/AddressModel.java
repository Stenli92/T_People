package com.example.demo.domain.models;

public class AddressModel {

    private String addrType;
    private String addrInfo;

    public AddressModel( String addrType, String addrInfo) {
        this.addrType = addrType;
        this.addrInfo = addrInfo;
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
}
