package com.example.internshipsignincontractapp.Model;

public class PenddingOffers {
    private String company;
    private String salary;
    private String position;
    private String skills;

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public PenddingOffers(String company, String salary, String position, String skills) {
        this.company = company;
        this.salary = salary;
        this.position = position;
        this.skills=skills;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
