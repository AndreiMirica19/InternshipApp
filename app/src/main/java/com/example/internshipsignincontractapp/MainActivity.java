package com.example.internshipsignincontractapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.internshipsignincontractapp.Model.DbConnector;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Button logInButton;
    private Intent loginIntent;
    private Intent signUpIntent;
    public static  DbConnector dbConnector;
    private TextInputEditText username;
    private TextInputEditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logInButton=findViewById(R.id.login_btn);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);

        loginIntent = new Intent(this,LogedInActivity.class);
        signUpIntent = new Intent(this,SignUp.class);
        dbConnector = new DbConnector();


    }

    public void LogInPressed(View view) {
        //

        if(dbConnector.credentialsValidator(username.getText().toString(),password.getText().toString())){

            startActivity(loginIntent);
        }
        //

    }

    public void SignUpPressed(View view) {
        startActivity(signUpIntent);
    }


    public void ForgotPassword(View view) {
        Intent intent = new Intent(this,RecoverAccount.class);
        startActivity(intent);
    }
}