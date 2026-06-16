package com.example.mobileapplicationdevelopmentassignment;

public class roomBookJavaClass {
    private int roomID;
    private String roomType, roomPrice, roomDescription, roomAvailability;

    private byte[] roomImage;

    public roomBookJavaClass() {
    }

    public roomBookJavaClass(String roomType, String roomPrice, String roomDescription, byte[] roomImage, String roomAvailability) {
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomDescription = roomDescription;
        this.roomImage = roomImage;
        this.roomAvailability=roomAvailability;
    }

    public roomBookJavaClass(int roomID, String roomType, String roomPrice, String roomDescription, byte[] roomImage) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomDescription = roomDescription;
        this.roomImage = roomImage;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public byte[] getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(byte[] roomImage) {
        this.roomImage = roomImage;
    }

    public String getRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(String roomAvailability) {
        this.roomAvailability = roomAvailability;
    }
}
