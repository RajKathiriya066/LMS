package com.example.LMS.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OPERATOR",schema = "books")
public class Operator {

    @Id
    private String email;
    private String name;
    private String pass;

    public Operator(String email, String name, String pass) {
        this.email = email;
        this.name = name;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
