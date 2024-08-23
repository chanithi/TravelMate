package com.example.travelmate;

public class User {
    private String name;
    private String contact;
    private String district;
    private String userType;
    private String email;
    private String password;

    public User() {
        // Required empty constructor for Firestore to deserialize documents
    }

    // Constructor that accepts all fields
    public User(String name, String contact, String district, String userType, String email, String password) {
        this.name = name;
        this.contact = contact;
        this.district = district;
        this.userType = userType;
        this.email = email;
        this.password = password;
    }

    // Getters and setters (optional, if you need to access these fields)
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

//
//public class User {
//    private String name;
//    private String contact;
//    private String district;
//    private String userType;
//
//    public User() {
//        // Default constructor required for Firestore serialization
//    }
//
//    public User(String name, String contact, String district, String userType) {
//        this.name = name;
//        this.contact = contact;
//        this.district = district;
//        this.userType = userType;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getContact() {
//        return contact;
//    }
//
//    public String getDistrict() {
//        return district;
//    }
//
//    public String getUserType() {
//        return userType;
//    }
//}
//package com.example.travelmate;
//
//public class User {
//    private String name;
//    private String contact;
//    private String district;
//    private String userType;
//    private String imageUrl;
//
//    public User() {
//        // Default constructor required for Firestore serialization
//    }
//
//    public User(String name, String contact, String district, String userType, String imageUrl) {
//        this.name = name;
//        this.contact = contact;
//        this.district = district;
//        this.userType = userType;
//        this.imageUrl = imageUrl;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getContact() {
//        return contact;
//    }
//
//    public String getDistrict() {
//        return district;
//    }
//
//    public String getUserType() {
//        return userType;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//}