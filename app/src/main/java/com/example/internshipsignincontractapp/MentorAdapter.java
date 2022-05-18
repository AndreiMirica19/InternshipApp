package com.example.internshipsignincontractapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.internshipsignincontractapp.Model.Candidate;
import com.example.internshipsignincontractapp.Model.DbConnector;
import com.example.internshipsignincontractapp.Model.Internship;

import java.util.List;

public class MentorAdapter extends ArrayAdapter<Candidate> {
    private Context context;
    int resource;
    public MentorAdapter(@NonNull Context context, int resource, @NonNull List<Candidate> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DbConnector dbConnector = DbConnector.getInstance();
        String name = getItem(position).getName();
        String group = getItem(position).getGroup();
        String company =getItem(position).getCompany();
        String salary = getItem(position).getSalary();
        String job_position = getItem(position).getPosition();
        String skills = getItem(position).getSkills();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource,parent,false);
        TextView nameText =convertView.findViewById(R.id.candidate_name);
        TextView groupText = convertView.findViewById(R.id.candidate_group);

        TextView companyText = convertView.findViewById(R.id.companyName);
        TextView pos = convertView.findViewById(R.id.position);
        TextView skill =convertView.findViewById(R.id.skillEnum);
        TextView salaryText = convertView.findViewById(R.id.salary_input);

        Button btn = convertView.findViewById(R.id.apply_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbConnector.sendConventionToAdmin(position);
            }
        });
        companyText.setText(company);
        nameText.setText(name);
        groupText.setText(group);
        pos.setText(job_position);
        skill.setText(skills);
        salaryText.setText(salary);
        return convertView;


    }

}
