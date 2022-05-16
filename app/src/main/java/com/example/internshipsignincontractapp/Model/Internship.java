package com.example.internshipsignincontractapp.Model;

import java.util.ArrayList;

public class Internship {
    private String offer;
    private String skills;
    private String salary;
    private String company;
    private String id;
    private ArrayList<String>candidatesId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Internship(String offer, String skills, String company) {
        this.offer = offer;
        this.skills = skills;
        this.salary = "none";
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Internship(String offer, String skills, String salary, String company) {
        this.offer = offer;
        this.skills = skills;
        this.salary = salary;
        this.company = company;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public ArrayList<String> getCandidatesId() {
        return candidatesId;
    }

    public void setCandidatesId(ArrayList<String> candidatesId) {
        this.candidatesId = candidatesId;
    }
}
