package com.example.mobileapplicationdevelopmentassignment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class manageRoomBookings extends AppCompatActivity {
    private EditText emailTXT;

    private Button proceedBtn;

    private luxeVistaDB luxeVistaDB;

    private Context context;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manage_room_bookings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailTXT=findViewById(R.id.bookingEmail);
        proceedBtn=findViewById(R.id.proceedBtn);
        context=this;
        luxeVistaDB=new luxeVistaDB(context);

        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailTXT.getText().toString();

                if(luxeVistaDB.validateRoomBookingEmail(email)){
                    retriewData(email);
                }else{
                    Toast.makeText(context, "There's no any bookings for this email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void retriewData(String email){
        Cursor cursor=luxeVistaDB.getBookingsByEmail(email);

        ArrayList<manageRoomBookingsJavaClass> bookingList=new ArrayList<>();

        while(cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndexOrThrow(luxeVistaDB.Booking_ID));
            String fullName=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Booking_Full_Name));
            String bookingEmail=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Booking_Email));
            String roomType=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Booking_Room_Type));

            bookingList.add(new manageRoomBookingsJavaClass(id, fullName, roomType, bookingEmail));
        }

        cursor.close();

        manageRoomBookingAdapter adapter=new manageRoomBookingAdapter(this, bookingList);
        RecyclerView recyclerView=findViewById(R.id.recyclerBookingView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}