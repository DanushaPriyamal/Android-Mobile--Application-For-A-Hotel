package com.example.mobileapplicationdevelopmentassignment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class manageProfilePage extends AppCompatActivity {
    private EditText fullNameInput, emailInput, travelDatesInput, preferencesInput;

     private Button saveButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manage_profile_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fullNameInput = findViewById(R.id.full_name_input_manage_profile);
        emailInput = findViewById(R.id.manage_profile_email_input);
        travelDatesInput = findViewById(R.id.travel_dates_input);
        preferencesInput = findViewById(R.id.preferences_input);
        saveButton= findViewById(R.id.saveBtn);

        luxeVistaDB luxeVistaDB = new luxeVistaDB(this);

        saveButton.setOnClickListener(v -> {
            String name = fullNameInput.getText().toString();
            String email = emailInput.getText().toString();
            String travelDates = travelDatesInput.getText().toString();
            String preferencesI = preferencesInput.getText().toString();

            boolean success = luxeVistaDB.updateTravelDatesAndPreferences(name, email, travelDates, preferencesI);
            if (success) {
                Toast.makeText(this, "Saved successfully!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Saving data isn't successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}