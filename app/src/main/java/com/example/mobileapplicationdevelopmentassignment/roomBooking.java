package com.example.mobileapplicationdevelopmentassignment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class roomBooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_room_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        luxeVistaDB luxeVistaDB = new luxeVistaDB(this);

        SharedPreferences prefs=getSharedPreferences("RoomPrefs", MODE_PRIVATE);
        boolean isDataInserted=prefs.getBoolean("isDataInserted", false);

        if(!isDataInserted){
            Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ocean_view_room);
            Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.deluxe_room);

            byte[] imageBytes1 = getBytesFromBitmap(bitmap1);
            byte[] imageBytes2 = getBytesFromBitmap(bitmap2);

            luxeVistaDB.insertRoom("Ocean View Suit", "RS. 25000 per night", "Room with a beautiful ocean view", imageBytes1, "Available");
            luxeVistaDB.insertRoom("Deluxe Room", "RS.20000 per night", "Room with a luxury facilities", imageBytes2, "Available");

            SharedPreferences.Editor editor=prefs.edit();
            editor.putBoolean("isDataInserted", true);
            editor.apply();
        }

        Spinner sortSpinner=findViewById(R.id.sortSpinner);
        String[] options={"Sort by Room Type", "Sort by Price (Low to High)", "Sort by Price (High to Low)", "Sort by Availability" };
        ArrayAdapter<String> adapterSpinner=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortSpinner.setAdapter(adapterSpinner);

        Cursor cursor=luxeVistaDB.getSortedRooms("Room_ID");

        ArrayList<roomBookJavaClass> roomList=new ArrayList<>();
        while(cursor.moveToNext()){
            String type=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Room_Type));
            String price=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Price));
            String description=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Room_Description));
            byte[] image=cursor.getBlob(cursor.getColumnIndexOrThrow(luxeVistaDB.Room_Image));
            String availability=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Room_Availability));

            roomList.add(new roomBookJavaClass(type, price, description, image, availability));

        }

        cursor.close();

        roomBookingAdapter adapter=new roomBookingAdapter(this, roomList);
        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        sortSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onItemSelected(AdapterView<?> Parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        Collections.sort(roomList, (r1, r2) -> r1.getRoomType().compareToIgnoreCase(r2.getRoomType()));
                        break;

                    case 1:
                        Collections.sort(roomList, Comparator.comparingInt(r -> extractPrice(r.getRoomPrice())));
                        break;

                    case 2:
                        Collections.sort(roomList, (r1, r2) -> extractPrice(r2.getRoomPrice()) - extractPrice(r1.getRoomPrice()));
                        break;

                    case 3:
                        Collections.sort(roomList, (r1, r2) -> r1.getRoomAvailability().compareToIgnoreCase(r2.getRoomAvailability()));
                        break;
                }
                adapter.notifyDataSetChanged();

            }

            private int extractPrice(String priceText) {
                String digits=priceText.replaceAll("[^0-9]", "");
                return digits.isEmpty() ? 0 : Integer.parseInt(digits);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();

    }


    public void bookConfirmNavigation(View view) {
        Intent intent=new Intent(roomBooking.this, roomBookingForm.class);
        startActivity(intent);
    }
}