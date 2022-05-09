package com.example.internshipsignincontractapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.internshipsignincontractapp.Model.DbConnector;
import com.example.internshipsignincontractapp.Model.Users;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Objects;

public class SignUp extends AppCompatActivity
{
    private TextInputEditText username;
    private TextInputEditText password;
    private TextInputEditText email;
    TextInputLayout labelAccountType;
    AutoCompleteTextView accountInput;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        labelAccountType = findViewById(R.id.menu);
        accountInput = findViewById(R.id.acc_input);
        username = findViewById(R.id.usernameInput);
        password = findViewById(R.id.PasswordInput);
        email = findViewById(R.id.email_input);
        ArrayList<String>options = new ArrayList<>();
        options.add("Student");
        options.add("Mentor");
        options.add("Admin");
        options.add("Firm");
        ArrayAdapter<String> accountAdapter = new ArrayAdapter<>(getApplicationContext(), R.layout.account_type,options);
        accountInput.setAdapter(accountAdapter);
    }

    public void alreadyUserBtnPressed(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void SignUpPressed(View view) {
        Intent intent;
        MainActivity.dbConnector.addUser(
                new Users(Objects.requireNonNull(username.getText()).toString()
                ,Objects.requireNonNull(password.getText().toString()),
                Objects.requireNonNull(email.getText().toString())),
                Objects.requireNonNull(accountInput.getText().toString()));
        if(accountInput.getText().toString().equals("Student")){
            intent= new Intent(this,LogedInActivity.class);
            startActivity(intent);
        }
        else{
            if(accountInput.getText().toString().equals("Mentor")){
                intent= new Intent(this,MainPageMentor.class);
                startActivity(intent);
            }
            else{
                if(accountInput.getText().toString().equals("Admin")){
                    intent= new Intent(this,MainPageAdmin.class);
                    startActivity(intent);
                }
                else{
                    if(accountInput.getText().toString().equals("Firm")){
                        intent= new Intent(this,MainPageCompany.class);
                        startActivity(intent);
                    }
                }
            }
        }

    }
}
