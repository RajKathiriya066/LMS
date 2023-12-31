package com.example.LMS.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import java.time.LocalDate;

@Entity
@Table(name = "BOOKS", schema = "books")
public class Books {
    @Id
    private String isbn;
    private String name;
    private String author;
    private LocalDate issue_date;
    private int copies;

    public Books(String isbn, String name, String author, LocalDate issue_date,int copies) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.issue_date = issue_date;
        this.copies=copies;
    }

    public Books(){
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(LocalDate issue_date) {
        this.issue_date = issue_date;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}
