package com.example.internshipsignincontractapp.Model;

public class Candidate {
    private String name;
    private String position;
    private String group;
    private String id;
    private String status="applied";
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Candidate(String name, String position, String group, String id) {
        this.name = name;
        this.position = position;
        this.group = group;
        this.id = id;
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
