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

import java.util.List;

public class CompanyAdapter extends ArrayAdapter<Company> {
    private Context context;
    int resource;
    public CompanyAdapter(@NonNull Context context, int resource, @NonNull List<Company> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DbConnector dbConnector = DbConnector.getInstance();
        String name =getItem(position).getName() ;
        String address=getItem(position).getAdress();
        String description= getItem(position).getDescription();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resource,parent,false);
        TextView company = convertView.findViewById(R.id.companyName);
        TextView address_label = convertView.findViewById(R.id.address);
        TextView description_label =convertView.findViewById(R.id.description);
        if(name!=null)
        company.setText(name);
        if(address!=null)
        address_label.setText(address);
        if(description_label!=null)
        description_label.setText(description);

        return convertView;


    }
}
