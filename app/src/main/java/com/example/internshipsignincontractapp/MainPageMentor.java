package com.example.internshipsignincontractapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPageMentor extends AppCompatActivity {
    BottomNavigationView bottomNavigationMenuView;

    FrameLayout navHostController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page_mentor);
        getSupportActionBar().hide();

        bottomNavigationMenuView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navHostController = findViewById(R.id.fragmentContainerView_Mentor);
        replaceFragment(new main_page_mentor_fragment());
        bottomNavigationMenuView.setOnNavigationItemSelectedListener(item->{
            switch (item.getItemId()){
                case R.id.page_home:
                    replaceFragment(new main_page_mentor_fragment());
                    break;
                case R.id.Log_Out:
                    AlertDialog alertDialog = new AlertDialog.Builder(MainPageMentor.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Are you sure you want to log out");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(MainPageMentor.this,MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertDialog.show();

                    break;
            }
            return true;
        });
    }
    private  void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView_Mentor,fragment);
        fragmentTransaction.commit();


    }
    }

