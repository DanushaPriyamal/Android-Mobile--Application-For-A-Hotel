package com.example.mobileapplicationdevelopmentassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void manageProfileNavigation(View view) {
        Intent intent=new Intent(mainPage.this, manageProfilePage.class);
        startActivity(intent);
    }

    public void bookRoomsNavigation(View view) {
        Intent intent=new Intent(mainPage.this, roomBooking.class);
        startActivity(intent);
    }

    public void manageRoomBookingNaviagtion(View view) {
        Intent intent=new Intent(mainPage.this, manageRoomBookings.class);
        startActivity(intent);
    }

    public void serviceReservationNavigation(View view) {
        Intent intent=new Intent(mainPage.this, serviceReservation.class);
        startActivity(intent);
    }

    public void serviceReservationCalenderNavigation(View view) {
        Intent intent=new Intent(mainPage.this, serviceReservationCalender.class);
        startActivity(intent);
    }

    public void manageServiceReservationNavigation(View view) {
        Intent intent=new Intent(mainPage.this, manageServiceReservations.class);
        startActivity(intent);
    }

    public void offersAndNearbyAttractionsNavigation(View view) {
        Intent intent=new Intent(mainPage.this, offersAndNearbyAttractions.class);
        startActivity(intent);
    }

    public void notificationNavigation(View view) {
        Intent intent=new Intent(mainPage.this, notificationPage.class);
        startActivity(intent);
    }

    public void logOutNavigation(View view) {
        Intent intent=new Intent(mainPage.this, MainActivity.class);
        startActivity(intent);
    }
}