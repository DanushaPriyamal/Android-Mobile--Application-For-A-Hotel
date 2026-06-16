package com.example.mobileapplicationdevelopmentassignment;

import android.content.Context;
import android.database.Cursor;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class manageServiceReservations extends AppCompatActivity {
    private EditText emailtxt;

    private Button proceedBtn;

    private luxeVistaDB luxeVistaDB;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manage_service_reservations);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailtxt=findViewById(R.id.reservationEmail);
        proceedBtn=findViewById(R.id.proceedReservationBtn);
        context=this;
        luxeVistaDB=new luxeVistaDB(context);

        proceedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailtxt.getText().toString();

                if(luxeVistaDB.validateReservationEmail(email)){
                    retriewReservationData(email);
                }else{
                    Toast.makeText(context, "There's no any reservation for this email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void retriewReservationData(String email){
        Cursor cursor=luxeVistaDB.getReservationsByEmail(email);

        ArrayList<manageServiceReservationJavaClass> reservationServiceList=new ArrayList<>();

        while(cursor.moveToNext()){
            int id= cursor.getInt(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Reservation_ID));
            String type=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Reservation_Type));
            String fullName=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Reservation_Full_Name));
            String emailData= cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Reservation_Email));
            String date= cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Reservation_Date));
            String time=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Reservation_Time));

            reservationServiceList.add(new manageServiceReservationJavaClass(id, fullName, emailData, type, date, time));
        }

        cursor.close();

        manageServiceReservationsAdapter adapter=new manageServiceReservationsAdapter(this, reservationServiceList);
        RecyclerView recyclerView=findViewById(R.id.recyclerReservationView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}