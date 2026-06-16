package com.example.mobileapplicationdevelopmentassignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class roomBookingForm extends AppCompatActivity {
    private EditText fullNameTXT, emailTXT, roomTypeTXT;

    private Button roomBookingBtn;

    private luxeVistaDB luxeVistaDB;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_room_booking_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fullNameTXT=findViewById(R.id.full_name_room_booking);
        emailTXT=findViewById(R.id.email_room_booking);
        roomTypeTXT=findViewById(R.id.room_type);
        roomBookingBtn=findViewById(R.id.roomBookBtn);
        context=this;

        luxeVistaDB=new luxeVistaDB(context);

        roomBookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName=fullNameTXT.getText().toString();
                String email=emailTXT.getText().toString();
                String roomType=roomTypeTXT.getText().toString();

                if(luxeVistaDB.validateUserData(fullName, email)){
                    roomBookingTableJavaClass rbtjc=new roomBookingTableJavaClass(fullName, email, roomType);
                    luxeVistaDB.addRoomBookingData(rbtjc);

                    Toast.makeText(context, "Room booked Successfully!", Toast.LENGTH_LONG).show();

                   boolean success =luxeVistaDB.updateRoomAvailability(roomType, "Not Available");

                   Intent intent=new Intent(roomBookingForm.this, mainPage.class);
                   startActivity(intent);

                }else{
                    Toast.makeText(context, "Please use Full Name and Email which is used to create your account", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}