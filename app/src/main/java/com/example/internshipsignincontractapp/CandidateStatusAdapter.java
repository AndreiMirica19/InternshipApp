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
import com.example.internshipsignincontractapp.Model.DbConnector;

import java.util.List;

public class CandidateStatusAdapter extends ArrayAdapter<Candidate> {
    private Context context;
    int resource;
    public CandidateStatusAdapter(@NonNull Context context, int resource, @NonNull List<Candidate> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String name = getItem(position).getName();
        String group = getItem(position).getGroup();
        String company =getItem(position).getCompany();
        String salary = getItem(position).getSalary();
        String job_position = getItem(position).getPosition();
        String skills = getItem(position).getSkills();
        String status = getItem(position).getStatus();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource,parent,false);
        TextView nameText =convertView.findViewById(R.id.candidate_name);
        TextView groupText = convertView.findViewById(R.id.candidate_group);

        TextView companyText = convertView.findViewById(R.id.companyName);
        TextView pos = convertView.findViewById(R.id.position);
        TextView skill =convertView.findViewById(R.id.skillEnum);
        TextView salaryText = convertView.findViewById(R.id.salary_input);
        TextView statusText = convertView.findViewById(R.id.Status);
        companyText.setText(company);
        nameText.setText(name);
        groupText.setText(group);
        pos.setText(job_position);
        skill.setText(skills);
        salaryText.setText(salary);
        statusText.setText(status);
        return convertView;


    }

}
