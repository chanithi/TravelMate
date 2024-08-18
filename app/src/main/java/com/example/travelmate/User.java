package com.example.travelmate;

public class User {
    private String name;
    private String contact;
    private String district;
    private String userType;

    public User() {
        // Default constructor required for Firestore serialization
    }

    public User(String name, String contact, String district, String userType) {
        this.name = name;
        this.contact = contact;
        this.district = district;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getDistrict() {
        return district;
    }

    public String getUserType() {
        return userType;
    }
}
