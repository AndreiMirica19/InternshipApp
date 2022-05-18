package com.example.internshipsignincontractapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.internshipsignincontractapp.Model.DbConnector;
import com.example.internshipsignincontractapp.Model.Students;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Objects;

public class sign_up_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DbConnector dbConnector = DbConnector.getInstance();
   static TextInputEditText username;
   static TextInputEditText password;
    static TextInputEditText email;
   static TextInputLayout labelAccountType;
  static   AutoCompleteTextView accountInput;
    public sign_up_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment edit_account_student_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static sign_up_fragment newInstance(String param1, String param2) {
        sign_up_fragment fragment = new sign_up_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        labelAccountType = view.findViewById(R.id.menu);
        accountInput = view.findViewById(R.id.acc_input);
        username = view.findViewById(R.id.usernameInput);
        password = view.findViewById(R.id.PasswordInput);
        email = view.findViewById(R.id.email_input);
        ArrayList<String> options = new ArrayList<>();
        options.add("Student");
        options.add("Mentor");
        options.add("Admin");
        options.add("Firm");
        ArrayAdapter<String> accountAdapter = new ArrayAdapter<>(view.getContext(),R.layout.account_type,options);
        accountInput.setAdapter(accountAdapter);
        Button btn = view.findViewById(R.id.signUp_btn);

    }
    public static  void SignUpPressed(View view) {
        Toast.makeText(view.getContext(),"Account added",Toast.LENGTH_SHORT).show();
     MainActivity.dbConnector.addUser(
              new Students(Objects.requireNonNull(username.getText()).toString()
                        ,Objects.requireNonNull(password.getText().toString()),
                      Objects.requireNonNull(email.getText().toString())),
              Objects.requireNonNull(accountInput.getText().toString()));


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.sign_up_fragment, container, false);
    }
}
