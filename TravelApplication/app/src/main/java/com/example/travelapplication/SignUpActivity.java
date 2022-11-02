package com.example.travelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.travelapplication.databinding.ActivityMainBinding;

public class SignUpActivity extends AppCompatActivity {
    EditText edtxtUNsignup;
    EditText edtxtPWsignup;
    EditText edtxtEmail;
    EditText edtxtPhone;
    Button btnBackSU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        AnhXa();
        hideUnderBarInEditText(edtxtPWsignup);

        btnBackSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(SignUpActivity.this, StartActivity.class);
                startActivity(myIntent);
            }
        });
    }

    public void AnhXa(){
        edtxtUNsignup=(EditText) findViewById(R.id.editTextUserNameSU);
        edtxtPWsignup=(EditText)  findViewById(R.id.editTextPassSU);
        edtxtEmail=(EditText) findViewById(R.id.editTextEmail);
        edtxtPhone=(EditText) findViewById(R.id.editTextSDT);
        btnBackSU=(Button)  findViewById(R.id.buttonBackSU);
    }
    public void hideUnderBarInEditText(EditText editText){
        editText.setBackgroundResource(android.R.color.transparent);
    }
}