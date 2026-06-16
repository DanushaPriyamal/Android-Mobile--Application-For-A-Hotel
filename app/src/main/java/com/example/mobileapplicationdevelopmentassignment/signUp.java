package com.example.mobileapplicationdevelopmentassignment;

public class signUp {
    private int su_ID, su_Status;

    private String su_Full_Name, su_Email, su_Password, su_Mobile_Number;

    public signUp() {
    }

    public signUp(String su_Mobile_Number, int su_Status, String su_Full_Name, String su_Email, String su_Password) {
        this.su_Mobile_Number = su_Mobile_Number;
        this.su_Status = su_Status;
        this.su_Full_Name = su_Full_Name;
        this.su_Email = su_Email;
        this.su_Password = su_Password;
    }

    public signUp(int su_ID, String su_Mobile_Number, int su_Status, String su_Full_Name, String su_Email, String su_Password) {
        this.su_ID = su_ID;
        this.su_Mobile_Number = su_Mobile_Number;
        this.su_Status = su_Status;
        this.su_Full_Name = su_Full_Name;
        this.su_Email = su_Email;
        this.su_Password = su_Password;
    }

    public int getSu_ID() {
        return su_ID;
    }

    public void setSu_ID(int su_ID) {
        this.su_ID = su_ID;
    }

    public String getSu_Mobile_Number() {
        return su_Mobile_Number;
    }

    public void setSu_Mobile_Number(String su_Mobile_Number) {
        this.su_Mobile_Number = su_Mobile_Number;
    }

    public int getSu_Status() {
        return su_Status;
    }

    public void setSu_Status(int su_Status) {
        this.su_Status = su_Status;
    }

    public String getSu_Full_Name() {
        return su_Full_Name;
    }

    public void setSu_Full_Name(String su_Full_Name) {
        this.su_Full_Name = su_Full_Name;
    }

    public String getSu_Email() {
        return su_Email;
    }

    public void setSu_Email(String su_Email) {
        this.su_Email = su_Email;
    }

    public String getSu_Password() {
        return su_Password;
    }

    public void setSu_Password(String su_Password) {
        this.su_Password = su_Password;
    }
}
