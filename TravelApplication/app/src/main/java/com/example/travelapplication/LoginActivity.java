package com.example.travelapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText edtxtUsername;
    EditText edtxrPassword;
    AppCompatButton btnLogin;
    TextView txtvSignup;
    Button btnbackWC;
    FirebaseAuth mAuth;
    CheckBox cbRemember;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        sharedpreferences = getBaseContext().getSharedPreferences("dataLogin", Context.MODE_PRIVATE);

        mAuth = FirebaseAuth.getInstance();

        edtxtUsername.setText(sharedpreferences.getString("taikhoan",""));
        edtxrPassword.setText(sharedpreferences.getString("matkhau",""));
        cbRemember.setChecked(sharedpreferences.getBoolean("checked",false));

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

                String uname = edtxtUsername.getText().toString().trim();
                String password = edtxrPassword.getText().toString().trim();
                if(cbRemember.isChecked()){
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("taikhoan",uname);
                    editor.putString("matkhau",password);
                    editor.putBoolean("checked",true);
                    editor.commit();
                }else {
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.remove("taikhoan");
                    editor.remove("matkhau");
                    editor.remove("checked");
                    editor.commit();
                }
                login();
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
        cbRemember = (CheckBox) findViewById(R.id.checkboxLuuMK);
    }
    public void login(){
        String email = edtxtUsername.getText().toString();
        String password = edtxrPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            edtxtUsername.setError("Email cannot be empty");
            edtxtUsername.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            edtxrPassword.setError("Password cannot be empty");
            edtxrPassword.requestFocus();
        }else{

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "User logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this, "Log in Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}