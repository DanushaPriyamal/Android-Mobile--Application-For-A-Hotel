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

public class serviceReservationForm extends AppCompatActivity {
    private EditText fullNameTXT, emailTXT, serviceTypeTXT, reservationDateTXT, reservationTimeTXT;

    private Button reservationBtn;

    private Context context;

    private luxeVistaDB luxeVistaDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_service_reservation_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fullNameTXT=findViewById(R.id.full_name_service_reservation);
        emailTXT=findViewById(R.id.email_service_reservation);
        serviceTypeTXT=findViewById(R.id.service_type);
        reservationDateTXT=findViewById(R.id.service_reservation_dates);
        reservationTimeTXT=findViewById(R.id.service_reservation_time);
        reservationBtn=findViewById(R.id.serviceReservationBtn);
        context=this;

        luxeVistaDB =new luxeVistaDB(context);

        reservationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName=fullNameTXT.getText().toString();
                String email=emailTXT.getText().toString();
                String serviceType=serviceTypeTXT.getText().toString();
                String reservationDate=reservationDateTXT.getText().toString();
                String reservationTime=reservationTimeTXT.getText().toString();

                if(luxeVistaDB.validateUserData(fullName, email)){
                    serviceReservationFormJavaClass srfjc=new serviceReservationFormJavaClass(fullName, email, serviceType, reservationDate, reservationTime);
                    luxeVistaDB.addServiceReservationData(srfjc);

                    Toast.makeText(context, "Service reservation is successful!", Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(serviceReservationForm.this, mainPage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(context, "Please use Full Name and Email which is used to create your account", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}