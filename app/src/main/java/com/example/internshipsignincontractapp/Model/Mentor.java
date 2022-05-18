package com.example.internshipsignincontractapp.Model;

public class Mentor extends Account{
    private String id;
    public Mentor(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
