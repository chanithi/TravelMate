package com.example.travelmate;

public class BookingDetails {
    private String requesterName;
    private String fromDate;
    private String toDate;
    private String providerEmail;
//    private String providerContact;
    private String requesterEmail;
    private String requesterContact;
    private String status; // Add this field to track the status of the request

    // Default constructor required for Firestore serialization
    public BookingDetails() {
    }

    public BookingDetails(String requesterName, String fromDate, String toDate, String providerEmail,  String requesterEmail, String requesterContact, String status) {
        this.requesterName = requesterName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.providerEmail = providerEmail;
//        this.providerContact = providerContact;
        this.requesterEmail = requesterEmail;
        this.requesterContact = requesterContact;
        this.status = status;
    }

    // Getters and setters for all fields
    public String getRequesterName() { return requesterName; }
    public void setRequesterName(String requesterName) { this.requesterName = requesterName; }
    public String getFromDate() { return fromDate; }
    public void setFromDate(String fromDate) { this.fromDate = fromDate; }
    public String getToDate() { return toDate; }
    public void setToDate(String toDate) { this.toDate = toDate; }
    public String getProviderEmail() { return providerEmail; }
    public void setProviderEmail(String providerEmail) { this.providerEmail = providerEmail; }
    //public String getProviderContact() { return providerContact; }
    //public void setProviderContact(String providerContact) { this.providerContact = providerContact; }
    public String getRequesterEmail() { return requesterEmail; }
    public void setRequesterEmail(String requesterEmail) { this.requesterEmail = requesterEmail; }
    public String getRequesterContact() { return requesterContact; }
    public void setRequesterContact(String requesterContact) { this.requesterContact = requesterContact; }
    public String getStatus() { return status; } // Getter for status
    public void setStatus(String status) { this.status = status; } // Setter for status

    @Override
    public String toString() {
        return "Requester: " + requesterName + ", From: " + fromDate + ", To: " + toDate + ", Status: " + status;
    }
}