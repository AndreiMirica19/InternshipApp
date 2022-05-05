package com.example.internshipsignincontractapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }

    public void alreadyUserBtnPressed(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
