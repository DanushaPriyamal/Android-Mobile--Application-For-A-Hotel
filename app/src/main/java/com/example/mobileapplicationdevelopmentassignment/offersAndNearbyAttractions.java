package com.example.mobileapplicationdevelopmentassignment;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class offersAndNearbyAttractions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_offers_and_nearby_attractions);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        luxeVistaDB luxeVistaDB=new luxeVistaDB(this);

        SharedPreferences prefs=getSharedPreferences("oanPrefs", MODE_PRIVATE);
        boolean isDataInserted=prefs.getBoolean("isDataInserted", false);

        if(!isDataInserted){
            Bitmap bitmap1= BitmapFactory.decodeResource(getResources(), R.drawable.beach_tours);
            Bitmap bitmap2=BitmapFactory.decodeResource(getResources(), R.drawable.dining);
            Bitmap bitmap3=BitmapFactory.decodeResource(getResources(), R.drawable.water_sports);

            byte[] imageByte1=getBytesFromBitmap(bitmap1);
            byte[] imageByte2=getBytesFromBitmap(bitmap2);
            byte[] imageByte3=getBytesFromBitmap(bitmap3);

            luxeVistaDB.insertOffersAndNearbyAttractions("Beach Tours", "RS.25000", "Escape to paradise with our curated Beach Bliss Tour—where golden sands, turquoise waves, and unforgettable memories await.\n" +
                    "Guests can enjoy a guided coastal experience featuring:\n" +
                    "- Scenic beach walks and hidden coves\n" +
                    "- Optional water sports like snorkeling or paddleboarding\n" +
                    "- Sunset refreshments at a local beach café\n" +
                    "- Hassle-free transport from the hotel\n" +
                    "If you join for a beach tour before December 31 in 2025, you can get a 20% of discount. You can reserve this service at the hotel premises.", imageByte1);
            luxeVistaDB.insertOffersAndNearbyAttractions("Water Sports", "RS.35000", "Dive into adrenaline with our Wave Rider Experience—where the ocean becomes your playground.\n" +
                    "Guests can choose from thrilling water activities including:\n" +
                    "- Jet Skiing: Speed across the waves like a pro\n" +
                    "- Banana Boat Rides: Group fun with splashes and laughter\n" +
                    "- Snorkeling: Discover vibrant marine life just beneath the surface\n" +
                    "- Kayaking: Paddle through serene coastal waters\n" +
                    "You can join to experience these adventures by reserving at the hotel premises", imageByte3);
            luxeVistaDB.insertOffersAndNearbyAttractions("Dinning", "RS10000 to 100000 per person", "Savor every bite with our Flavors of Paradise dining experience—where local charm meets global cuisine.\n" +
                    "Guests can indulge in:\n" +
                    "- Authentic Sri Lankan dishes crafted with fresh, local ingredients\n" +
                    "- International favorites from Italian pastas to Asian stir-fries\n" +
                    "- Romantic beachfront dinners and cozy in-room service\n" +
                    "- Live cooking stations and themed buffet night\n" +
                    "If you book a room for stay five days at the hotel with a booking one of these dinings, you can experience it free for the final day", imageByte2);

            SharedPreferences.Editor editor=prefs.edit();
            editor.putBoolean("isDataInserted", true);
            editor.apply();
        }

        Cursor cursor=luxeVistaDB.getOffersAndNearbyAttractionsDetails();

        ArrayList<offersAndNearbyAttractionsJavaClass> oanList=new ArrayList<>();
        while(cursor.moveToNext()){
            String topic=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Offers_And_Attractions_Topic));
            String price=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Offers_And_Attractions_Price));
            String description=cursor.getString(cursor.getColumnIndexOrThrow(luxeVistaDB.Offers_And_Attractions_Description));
            byte[] image=cursor.getBlob(cursor.getColumnIndexOrThrow(luxeVistaDB.Offers_And_Attractions_Image));

            oanList.add(new offersAndNearbyAttractionsJavaClass(topic, price, description, image));
        }

        cursor.close();

        offersAndNearbyAttractionsAdapter adapter=new offersAndNearbyAttractionsAdapter(this, oanList);
        RecyclerView recyclerView=findViewById(R.id.recyclerOFNView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();

    }
}