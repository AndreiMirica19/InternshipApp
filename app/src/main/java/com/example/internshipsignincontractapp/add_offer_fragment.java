package com.example.internshipsignincontractapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.internshipsignincontractapp.Model.Company;
import com.example.internshipsignincontractapp.Model.DbConnector;
import com.example.internshipsignincontractapp.Model.Internship;
import com.google.android.material.textfield.TextInputEditText;

public class add_offer_fragment extends Fragment {
    private String mParam1;
    private String mParam2;
    private Button save_btn;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public add_offer_fragment(){

    }
    public static add_offer_fragment newInstance(String param1, String param2) {
        add_offer_fragment fragment = new add_offer_fragment();
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
        TextInputEditText offerName = view.findViewById(R.id.offerInput);
        TextInputEditText skills = view.findViewById(R.id.Languagesinput);
        TextInputEditText salary = view.findViewById(R.id.salary_input);
        Button btn = view.findViewById(R.id.addOffer);
       Company c =(Company)dbConnector.currentUser;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(offerName.getText()!=null&&skills.getText()!=null){
                   if(salary.getText()!=null)
                   dbConnector.addInternship(new Internship(offerName.getText().toString(),skills.getText().toString(),salary.getText().toString(),c.getName()));
                   else
                       dbConnector.addInternship(new Internship(offerName.getText().toString(),skills.getText().toString(),c.getName()));
               Toast.makeText(getContext(),"Offer added",Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.add_internship_fragment, container, false);
    }
}
