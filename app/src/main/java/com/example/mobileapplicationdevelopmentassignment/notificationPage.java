package com.example.mobileapplicationdevelopmentassignment;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class notificationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notification_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        luxeVistaDB luxeVistaDB=new luxeVistaDB(this);

        SharedPreferences prefs=getSharedPreferences("NotificationPrefs", MODE_PRIVATE);
        boolean isDataInserted=prefs.getBoolean("isDataInserted", false);

        if(!isDataInserted){
            luxeVistaDB.insertNotifications("Sunset Beach Party – Tonight at 6 PM!", "Join us for an unforgettable evening of music, cocktails, and ocean views at the beachfront. Live DJ, fire dancers, and complimentary welcome drinks await. Dress code: casual chic. Let the waves set the vibe! Tickets are available at hotel premises");
            luxeVistaDB.insertNotifications("Deluxe Escape: Save 15% on Luxury Stays!", "Indulge in comfort and elegance—our Deluxe Rooms are now 15% off for a limited time. Enjoy plush interiors, premium amenities, and serene views. Book now and elevate your stay with a touch of luxury!");
            luxeVistaDB.insertNotifications("New Morning Yoga Sessions – Daily at 7 AM!", "Start your day with calm and clarity—join our complimentary yoga classes on the garden deck. Led by certified instructors, perfect for all levels. Mats provided. Just bring yourself and good vibes!");

            SharedPreferences.Editor editor=prefs.edit();
            editor.putBoolean("isDataInserted", true);
            editor.apply();
        }

        Cursor cursor=luxeVistaDB.getNotificationDetails();

        ArrayList<notificationPageJavaClass> notificationList=new ArrayList<>();
        while(cursor.moveToNext()){
            String topic=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Notification_Topic));
            String description=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Notification_Description));

            notificationList.add(new notificationPageJavaClass(topic, description));
        }

        cursor.close();

        notificationPageAdapter adapter=new notificationPageAdapter(this, notificationList);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView=findViewById(R.id.recyclerNotificationView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}