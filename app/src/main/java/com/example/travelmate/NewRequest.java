package com.example.travelmate;

public class NewRequest {
    private String requesterName;
    private String fromDate;
    private String toDate;
    private String providerEmail;
    private String providerContact;
    private String status; // For tracking request status

    public NewRequest() {}

    public NewRequest(String requesterName, String fromDate, String toDate, String providerEmail, String providerContact, String status) {
        this.requesterName = requesterName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.providerEmail = providerEmail;
        this.providerContact = providerContact;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
