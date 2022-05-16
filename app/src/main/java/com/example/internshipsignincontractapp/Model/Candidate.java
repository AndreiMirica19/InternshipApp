package com.example.internshipsignincontractapp.Model;

public class Candidate {
    private String name;
    private String position;
    private String group;

    public Candidate(String name, String position, String group) {
        this.name = name;
        this.position = position;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
