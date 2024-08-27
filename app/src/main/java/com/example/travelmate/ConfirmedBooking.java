package com.example.travelmate;

public class ConfirmedBooking {
    private String requesterName;
    private String fromDate;
    private String toDate;
    private String requesterContact;
    private String providerEmail;

    // Default constructor for Firestore
    public ConfirmedBooking() {
    }

    public ConfirmedBooking(String requesterName, String fromDate, String toDate, String requesterContact, String providerEmail) {
        this.requesterName = requesterName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.requesterContact = requesterContact;
        this.providerEmail = providerEmail;
    }

    // Getters and setters
    public String getRequesterName() { return requesterName; }
    public void setRequesterName(String requesterName) { this.requesterName = requesterName; }

    public String getFromDate() { return fromDate; }
    public void setFromDate(String fromDate) { this.fromDate = fromDate; }

    public String getToDate() { return toDate; }
    public void setToDate(String toDate) { this.toDate = toDate; }

    public String getRequesterContact() { return requesterContact; }
    public void setRequesterContact(String requesterContact) { this.requesterContact = requesterContact; }

    public String getProviderEmail() { return providerEmail; }
    public void setProviderEmail(String providerEmail) { this.providerEmail = providerEmail; }
}
