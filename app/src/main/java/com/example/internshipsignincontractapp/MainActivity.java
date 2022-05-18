package com.example.internshipsignincontractapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.internshipsignincontractapp.Model.Admin;
import com.example.internshipsignincontractapp.Model.Company;
import com.example.internshipsignincontractapp.Model.DbConnector;
import com.example.internshipsignincontractapp.Model.Mentor;
import com.example.internshipsignincontractapp.Model.Students;
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
        getSupportActionBar().hide();
        logInButton=findViewById(R.id.login_btn);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);

        loginIntent = new Intent(this,LogedInActivity.class);

      //  signUpIntent = new Intent(this,SignUp.class);
        dbConnector = DbConnector.getInstance();


    }

    public void LogInPressed(View view) {
        //
       Intent loginCompanyIntent = new Intent(this,MainPageCompany.class);
        if(dbConnector.credentialsValidator(username.getText().toString(),password.getText().toString())){
            if(dbConnector.currentUser instanceof Students)
            startActivity(loginIntent);
            else
                if(dbConnector.currentUser instanceof Company)
                    startActivity(loginCompanyIntent);
          else
                    if(dbConnector.currentUser instanceof Mentor){
                        Intent intent = new Intent(this,MainPageMentor.class);
                        startActivity(intent);
                    }

          else{
                if(dbConnector.currentUser instanceof Admin){
                    Intent intent = new Intent(this,MainPageAdmin.class);
                    startActivity(intent);
                }
            }
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