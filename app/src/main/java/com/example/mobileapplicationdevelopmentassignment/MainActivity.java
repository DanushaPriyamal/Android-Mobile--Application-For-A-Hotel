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

public class MainActivity extends AppCompatActivity {

    private EditText emailtxt, passwordtxt;

    private Button signInBtn;

    private luxeVistaDB luxeVistaDB;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        emailtxt=findViewById(R.id.email_input);
        passwordtxt=findViewById(R.id.password_input);
        signInBtn=findViewById(R.id.sign_in_button);
        context=this;
        luxeVistaDB=new luxeVistaDB(context);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=emailtxt.getText().toString();
                String password=passwordtxt.getText().toString();

                if(luxeVistaDB.validateSignInData(email, password)){
                    Toast.makeText(context, "Sign In Successfully!", Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(MainActivity.this, mainPage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(context, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void signUpNavigation(View view) {
        Intent intent=new Intent(MainActivity.this, signUpPage.class);
        startActivity(intent);
    }
}