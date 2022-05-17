package com.example.internshipsignincontractapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.internshipsignincontractapp.Model.DbConnector;

public class MainPageCompanyFragment extends Fragment {
    private String mParam1;
    private String mParam2;
    private Button save_btn;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public MainPageCompanyFragment(){

    }
    public static MainPageCompanyFragment newInstance(String param1, String param2) {
        MainPageCompanyFragment fragment = new MainPageCompanyFragment();
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
        DbConnector dbConnector =DbConnector.getInstance();
        ListView listView = view.findViewById(R.id.listView);


        dbConnector.fetchCompanyInternships();
        CandidatesAdapter candidatesAdapter = new CandidatesAdapter(getContext(),R.layout.candidates_adapter,dbConnector.currentCompanyCandidates);
         listView.setAdapter(candidatesAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_page_firm_fragment, container, false);
    }
}
