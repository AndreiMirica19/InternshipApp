package com.example.internshipsignincontractapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavHostController;

import com.example.internshipsignincontractapp.Model.DbConnector;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class LogedInActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationMenuView;

    FrameLayout navHostController;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.main_page_student);

        bottomNavigationMenuView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navHostController = findViewById(R.id.fragmentContainerView);
        bottomNavigationMenuView.setOnNavigationItemSelectedListener(item->{
            switch (item.getItemId()){
                case R.id.main_page_student_fragment:
                    replaceFragment(new main_page_student_fragment());
                    break;
                case R.id.edit_account_student_fragment:
                    replaceFragment(new edit_account_student_fragment());
                    break;
                case R.id.sign_convention_student:
                    replaceFragment(new sign_convention_student());
                    break;
                case R.id.page_3:
                    AlertDialog alertDialog = new AlertDialog.Builder(LogedInActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Are you sure you want to log out");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                             Intent intent = new Intent(LogedInActivity.this,MainActivity.class);
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
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
        fragmentTransaction.commit();


    }
    public void SavePressed(View view){
        TextInputEditText name = findViewById(R.id.edit_student_name);
        TextInputEditText uniGroup = findViewById(R.id.uni_group);
        DbConnector dbConnector = DbConnector.getInstance();
        dbConnector.updateStudent(name.getText().toString(),uniGroup.getText().toString());
        Toast.makeText(this,"Profile updated",Toast.LENGTH_SHORT).show();
    }
}
