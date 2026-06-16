package com.example.mobileapplicationdevelopmentassignment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class serviceReservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_service_reservation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        luxeVistaDB luxeVistaDB=new luxeVistaDB(this);

        SharedPreferences prefs=getSharedPreferences("ServicePrefs", MODE_PRIVATE);
        boolean isDataInserted=prefs.getBoolean("isDataInserted", false);

        if(!isDataInserted){
            Bitmap bitmap1= BitmapFactory.decodeResource(getResources(), R.drawable.spa_treatments);
            Bitmap bitmap2= BitmapFactory.decodeResource(getResources(), R.drawable.fine_dinning);
            Bitmap bitmap3= BitmapFactory.decodeResource(getResources(), R.drawable.poolside_cabanas);
            Bitmap bitmap4= BitmapFactory.decodeResource(getResources(), R.drawable.guided_beach_tours);

            byte[] imageByte1=getBytesFromBitmap(bitmap1);
            byte[] imageByte2=getBytesFromBitmap(bitmap2);
            byte[] imageByte3=getBytesFromBitmap(bitmap3);
            byte[] imageByte4=getBytesFromBitmap(bitmap4);

            luxeVistaDB.insertServices("Spa Treatments", "RS.5000 per hour", "Enjoy a luxury type treatment with herbal products", imageByte1);
            luxeVistaDB.insertServices("Fine Dinning", "RS.5000 per person", "Enjoy a luxury type dishes at a high class hotel", imageByte2);
            luxeVistaDB.insertServices("Poolside Cabanas", "RS.25000", "Get a different experience with a poolside cabana", imageByte3);
            luxeVistaDB.insertServices("Guided Beach Tours", "RS.20000 per person", "Enjoy beach tours with experience staff members", imageByte4);

            SharedPreferences.Editor editor=prefs.edit();
            editor.putBoolean("isDataInserted", true);
            editor.apply();
        }

        Cursor cursor=luxeVistaDB.getServiceDetails();

        ArrayList<serviceReservationJavaClass> serviceList=new ArrayList<>();
        while(cursor.moveToNext()){
            String type=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Type));
            String price=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Price));
            String description=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Description));
            byte[] image=cursor.getBlob(cursor.getColumnIndexOrThrow(luxeVistaDB.Service_Image));

            serviceList.add(new serviceReservationJavaClass(type, price, description, image));
        }

        cursor.close();

        serviceReservationAdapter adapter=new serviceReservationAdapter(this, serviceList);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView=findViewById(R.id.recyclerServiceView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();

    }

    public void reserveConfirmNavigation(View view) {
        Intent intent=new Intent(serviceReservation.this, serviceReservationForm.class);
        startActivity(intent);
    }
}