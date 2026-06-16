package com.example.mobileapplicationdevelopmentassignment;

public class manageRoomBookingsJavaClass {
    private int roomBookingId;

    private String roomBookingFullName, roomBookingEmail, bookingRoomType;

    public manageRoomBookingsJavaClass() {
    }

    public manageRoomBookingsJavaClass(String roomBookingFullName, String roomBookingEmail, String bookingRoomType) {
        this.roomBookingFullName = roomBookingFullName;
        this.roomBookingEmail = roomBookingEmail;
        this.bookingRoomType = bookingRoomType;
    }

    public manageRoomBookingsJavaClass(int roomBookingId, String roomBookingFullName, String bookingRoomType, String roomBookingEmail) {
        this.roomBookingId = roomBookingId;
        this.roomBookingFullName = roomBookingFullName;
        this.bookingRoomType = bookingRoomType;
        this.roomBookingEmail = roomBookingEmail;
    }

    public int getRoomBookingId() {
        return roomBookingId;
    }

    public void setRoomBookingId(int roomBookingId) {
        this.roomBookingId = roomBookingId;
    }

    public String getRoomBookingEmail() {
        return roomBookingEmail;
    }

    public void setRoomBookingEmail(String roomBookingEmail) {
        this.roomBookingEmail = roomBookingEmail;
    }

    public String getRoomBookingFullName() {
        return roomBookingFullName;
    }

    public void setRoomBookingFullName(String roomBookingFullName) {
        this.roomBookingFullName = roomBookingFullName;
    }

    public String getBookingRoomType() {
        return bookingRoomType;
    }

    public void setBookingRoomType(String bookingRoomType) {
        this.bookingRoomType = bookingRoomType;
    }
}
