package com.example.internshipsignincontractapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import com.example.internshipsignincontractapp.Model.Company;
import com.example.internshipsignincontractapp.Model.DbConnector;
import com.example.internshipsignincontractapp.Model.Students;
import com.google.android.material.textfield.TextInputEditText;

public class update_company_info extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public update_company_info() {
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
    public static update_company_info newInstance(String param1, String param2) {
        update_company_info fragment = new update_company_info();
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
        DbConnector dbConnector = DbConnector.getInstance();
        TextInputEditText name = view.findViewById(R.id.companyNameInput);
        Company c = (Company) dbConnector.currentUser;
        name.setText(c.getName());

        TextInputEditText adress = view.findViewById(R.id.adress);
        adress.setText(c.getAdress());
        AppCompatEditText description = view.findViewById(R.id.description_input);
        description.setText(c.getDescription());
        Button btn = view.findViewById(R.id.save);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbConnector.updateAdress(name.getText().toString(),adress.getText().toString(),description.getText().toString());
            }
        });


       ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.company_update_company_fragment,container, false);
    }

}
