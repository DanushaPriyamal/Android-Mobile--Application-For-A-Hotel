package com.example.mobileapplicationdevelopmentassignment;

import android.database.Cursor;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class serviceReservationCalender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_service_reservation_calender);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        luxeVistaDB luxeVistaDB=new luxeVistaDB(this);

        Spinner sortSpinner=findViewById(R.id.sortServiceSpinner);
        String[] options={"Sort by service type", "Sort by service date"};
        ArrayAdapter<String> adapterSpinner=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        sortSpinner.setAdapter(adapterSpinner);

        Cursor cursor=luxeVistaDB.getSortedServices("Service_Reservation_ID");

        ArrayList<serviceReservationCalenderJavaClass> serviceList=new ArrayList<>();
        while(cursor.moveToNext()){
            String type=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Reservation_Type));
            String date=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Reservation_Date));
            String time=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Reservation_Time));

            serviceList.add(new serviceReservationCalenderJavaClass(type, date, time));
        }

        cursor.close();

        serviceReservationCalenderAdapter adapter=new serviceReservationCalenderAdapter(this, serviceList);
        RecyclerView recyclerView=findViewById(R.id.recyclerServiceBookingView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        sortSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:
                        Collections.sort(serviceList, (r1, r2) -> r1.getServiceType().compareToIgnoreCase(r2.getServiceType()));
                        break;

                    case 1:
                        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
                        Collections.sort(serviceList, (r1, r2) ->{
                            try {
                                Date date1 = sdf.parse(r1.getReservationDate());
                                Date date2=sdf.parse(r2.getReservationDate());
                                return date1.compareTo(date2);
                            } catch (ParseException e) {
                                e.printStackTrace();
                                return 0;
                            }
                        });
                        break;
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}