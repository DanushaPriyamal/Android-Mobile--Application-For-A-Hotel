package com.example.mobileapplicationdevelopmentassignment;

import android.annotation.SuppressLint;
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

public class signUpPage extends AppCompatActivity {
    private Button signUpBTN;

    private EditText fullName, email, mobileNumber, password, confirmPassword;

    private luxeVistaDB luxeVistaDB;

    private Context context;

    @SuppressLint("MissingInflatedID")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fullName=findViewById(R.id.full_name_input);
        email=findViewById(R.id.sign_up_email_input);
        mobileNumber=findViewById(R.id.mobile_number_input);
        password=findViewById(R.id.sign_up_password_input);
        confirmPassword=findViewById((R.id.sign_up_confirm_password_input));
        context=this;
        luxeVistaDB=new luxeVistaDB(context);
        signUpBTN=findViewById(R.id.sign_up_registration_button);

        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String signUpFullName=fullName.getText().toString();
                String signUpEmail=email.getText().toString();
                String signUpMobileNumber=mobileNumber.getText().toString();
                String signUpPassword=password.getText().toString();
                String signUpConfirmPassword=confirmPassword.getText().toString();

                if(signUpPassword.equals(signUpConfirmPassword)){
                    signUp sign_up=new signUp(signUpMobileNumber, 1, signUpFullName, signUpEmail, signUpPassword);
                    luxeVistaDB.addSignUpData(sign_up);

                    Toast.makeText(context, "Sign Up Successfully!", Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(context, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(context, "Password and Confirm Password must be same", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}