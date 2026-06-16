package com.example.mobileapplicationdevelopmentassignment;

public class serviceReservationJavaClass {
    private int serviceID;
    private String serviceType, servicePrice, serviceDescription;

    private byte[] serviceImage;

    public serviceReservationJavaClass() {
    }

    public serviceReservationJavaClass(int serviceID, String serviceType, String servicePrice, byte[] serviceImage, String serviceDescription) {
        this.serviceID = serviceID;
        this.serviceType = serviceType;
        this.servicePrice = servicePrice;
        this.serviceImage = serviceImage;
        this.serviceDescription = serviceDescription;
    }

    public serviceReservationJavaClass(String serviceType, String servicePrice, String serviceDescription, byte[] serviceImage) {
        this.serviceType = serviceType;
        this.servicePrice = servicePrice;
        this.serviceDescription = serviceDescription;
        this.serviceImage = serviceImage;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(String servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public byte[] getServiceImage() {
        return serviceImage;
    }

    public void setServiceImage(byte[] serviceImage) {
        this.serviceImage = serviceImage;
    }
}
