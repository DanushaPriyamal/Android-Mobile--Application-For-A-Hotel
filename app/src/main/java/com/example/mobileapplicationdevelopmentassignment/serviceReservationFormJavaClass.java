package com.example.mobileapplicationdevelopmentassignment;

public class serviceReservationFormJavaClass {
    private int reservationID;

    private String reservationFullName, reservationEmail, reservationType, reservationDate, reservationTime;

    public serviceReservationFormJavaClass() {
    }

    public serviceReservationFormJavaClass(String reservationFullName, String reservationEmail, String reservationType, String reservationDate, String reservationTime) {
        this.reservationFullName = reservationFullName;
        this.reservationEmail = reservationEmail;
        this.reservationType = reservationType;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
    }

    public serviceReservationFormJavaClass(int reservationID, String reservationFullName, String reservationEmail, String reservationType, String reservationDate, String reservationTime) {
        this.reservationID = reservationID;
        this.reservationFullName = reservationFullName;
        this.reservationEmail = reservationEmail;
        this.reservationType = reservationType;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public String getReservationFullName() {
        return reservationFullName;
    }

    public void setReservationFullName(String reservationFullName) {
        this.reservationFullName = reservationFullName;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public String getReservationType() {
        return reservationType;
    }

    public void setReservationType(String reservationType) {
        this.reservationType = reservationType;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }
}
