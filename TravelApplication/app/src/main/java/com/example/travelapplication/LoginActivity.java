package com.example.travelapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    EditText edtxtUsername;
    EditText edtxrPassword;
    AppCompatButton btnLogin;
    TextView txtvSignup;
    Button btnbackWC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();

        txtvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(myIntent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(LoginActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        btnbackWC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent=new Intent(LoginActivity.this, StartActivity.class);
                startActivity(myIntent);
            }
        });
    }
    public void AnhXa(){
        edtxtUsername = (EditText) findViewById(R.id.editTextUserName);
        edtxrPassword= (EditText) findViewById(R.id.editTextPass);
        btnLogin=(AppCompatButton) findViewById(R.id.buttonLogin);
        txtvSignup=(TextView) findViewById(R.id.textViewSignup);
        btnbackWC = (Button) findViewById(R.id.buttonBackWC);
    }
}