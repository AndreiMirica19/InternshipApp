package com.example.internshipsignincontractapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.internshipsignincontractapp.Model.DbConnector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sign_convention_student#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sign_convention_student extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sign_convention_student() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment sign_convention_student.
     */
    // TODO: Rename and change types and number of parameters
    public static sign_convention_student newInstance(String param1, String param2) {
        sign_convention_student fragment = new sign_convention_student();
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
        dbConnector.fetchUserPendingOffers();
        ConventionUserAdapter adapter = new ConventionUserAdapter(getContext(),R.layout.internships_adapter,dbConnector.conventionOffers);
        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_convention_student, container, false);
    }
}