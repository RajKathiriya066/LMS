package com.example.LMS.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "BookStatus",schema = "books")
public class bookStatus {
    @Id
    private String isbn;
    private ArrayList<String> requests;
    private ArrayList<Integer> deadline;

    public bookStatus(String isbn, ArrayList<String> requests, ArrayList<Integer> deadline) {
        this.isbn = isbn;
        this.requests = requests;
        this.deadline = deadline;
    }

    public bookStatus() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public ArrayList<String> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<String> requests) {
        this.requests = requests;
    }

    public ArrayList<Integer> getDeadline() {
        return deadline;
    }

    public void setDeadline(ArrayList<Integer> deadline) {
        this.deadline = deadline;
    }
}
