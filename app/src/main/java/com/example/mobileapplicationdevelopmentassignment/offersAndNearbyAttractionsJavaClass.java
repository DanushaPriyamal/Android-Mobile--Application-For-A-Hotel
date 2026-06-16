package com.example.mobileapplicationdevelopmentassignment;

public class offersAndNearbyAttractionsJavaClass {
    private String topic, price, description;

    private byte[] image;

    public offersAndNearbyAttractionsJavaClass() {
    }

    public offersAndNearbyAttractionsJavaClass(String topic, String price, String description, byte[] image) {
        this.topic = topic;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
