package com.example.travelmate;

public class BookingDetails {

    private String requesterName;
    private String fromDate;
    private String toDate;
    private String providerEmail;
    private String providerContact;

    // Default constructor required for calls to DataSnapshot.getValue(BookingDetails.class)
    public BookingDetails() {}

    public BookingDetails(String requesterName, String fromDate, String toDate, String providerEmail, String providerContact) {
        this.requesterName = requesterName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.providerEmail = providerEmail;
        this.providerContact = providerContact;
    }

    // Getters and setters

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getProviderEmail() {
        return providerEmail;
    }

    public void setProviderEmail(String providerEmail) {
        this.providerEmail = providerEmail;
    }

    public String getProviderContact() {
        return providerContact;
    }

    public void setProviderContact(String providerContact) {
        this.providerContact = providerContact;
    }
}