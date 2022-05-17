package com.example.internshipsignincontractapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.internshipsignincontractapp.Model.Candidate;
import com.example.internshipsignincontractapp.Model.Company;
import com.example.internshipsignincontractapp.Model.DbConnector;
import com.example.internshipsignincontractapp.Model.Internship;

import java.util.List;

public class CandidatesAdapter  extends ArrayAdapter<Candidate> {
    private Context context;
    int resource;
    public CandidatesAdapter(@NonNull Context context, int resource, @NonNull List<Candidate> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       DbConnector dbConnector = DbConnector.getInstance();
        String name =getItem(position).getName() ;
        String pos = getItem(position).getPosition();
        String group = getItem(position).getGroup();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource,parent,false);
        TextView company = convertView.findViewById(R.id.candidate_name);
        TextView job_position = convertView.findViewById(R.id.position);
        TextView groupText =convertView.findViewById(R.id.faculty);
        Button btn = convertView.findViewById(R.id.accept_btn);
        Button deleteBtn =convertView.findViewById(R.id.reject_btn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 dbConnector.deleteCandidate(position);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              dbConnector.sendOffer(position);
            }
        });
        company.setText(name);
    job_position.setText(pos);
        groupText.setText(group);

        return convertView;


    }

}
