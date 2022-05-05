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
        MainActivity.dbConnector.addUser(new Users("test","3","t"));
    }
}
