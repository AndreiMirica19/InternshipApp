package com.example.internshipsignincontractapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.internshipsignincontractapp.Model.Internship;

import java.util.List;

public class InternshipAdapter extends ArrayAdapter<Internship> {
    private Context context;
   int resource;
    public InternshipAdapter(@NonNull Context context, int resource, @NonNull List<Internship> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       String name =getItem(position).getCompany();
       String salary = getItem(position).getSalary();
       String job_position = getItem(position).getOffer();
       String skills = getItem(position).getSkills();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
       convertView = layoutInflater.inflate(resource,parent,false);
        TextView company = convertView.findViewById(R.id.companyName);
        TextView pos = convertView.findViewById(R.id.position);
        TextView skill =convertView.findViewById(R.id.skillEnum);
        TextView salaryText = convertView.findViewById(R.id.salary_input);
        company.setText(name);
        pos.setText(job_position);
        skill.setText(skills);
        salaryText.setText(salary);
        return convertView;


    }
}
