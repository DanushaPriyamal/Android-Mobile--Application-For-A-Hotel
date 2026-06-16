package com.example.mobileapplicationdevelopmentassignment;

public class serviceReservationCalenderJavaClass {
    private String serviceType, reservationDate, reservationTime;

    public serviceReservationCalenderJavaClass() {
    }

    public serviceReservationCalenderJavaClass(String serviceType, String reservationDate, String reservationTime) {
        this.serviceType = serviceType;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
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
