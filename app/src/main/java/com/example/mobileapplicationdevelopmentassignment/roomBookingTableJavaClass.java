package com.example.mobileapplicationdevelopmentassignment;

public class roomBookingTableJavaClass {
    private int bookingID;

    private String bookingFullName, bookingEmail, bookingRoomType;

    public roomBookingTableJavaClass() {
    }

    public roomBookingTableJavaClass(String bookingFullName, String bookingEmail, String bookingRoomType) {
        this.bookingFullName = bookingFullName;
        this.bookingEmail = bookingEmail;
        this.bookingRoomType = bookingRoomType;
    }

    public roomBookingTableJavaClass(int bookingID, String bookingFullName, String bookingRoomType, String bookingEmail) {
        this.bookingID = bookingID;
        this.bookingFullName = bookingFullName;
        this.bookingRoomType = bookingRoomType;
        this.bookingEmail = bookingEmail;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingFullName() {
        return bookingFullName;
    }

    public void setBookingFullName(String bookingFullName) {
        this.bookingFullName = bookingFullName;
    }

    public String getBookingEmail() {
        return bookingEmail;
    }

    public void setBookingEmail(String bookingEmail) {
        this.bookingEmail = bookingEmail;
    }

    public String getBookingRoomType() {
        return bookingRoomType;
    }

    public void setBookingRoomType(String bookingRoomType) {
        this.bookingRoomType = bookingRoomType;
    }
}
