package com.example.LMS.Controller;

import com.example.LMS.Service.ServicesAdmin;
import com.example.LMS.Users.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/admin")
public class ControllerAdmin {

    private final ServicesAdmin service;

    @Autowired
    public ControllerAdmin(ServicesAdmin service) {
        this.service = service;
    }


    @PostMapping("/add")
    public void addBook(@RequestBody Books books){
        service.addBook(books.getIsbn(),books.getName(),books.getAuthor(),books.getIssue_date(),books.getCopies());
    }
    @DeleteMapping("/del/{isbn}")
    public void removeBook(@PathVariable String isbn){
        service.removeBook(isbn);
    }
    @GetMapping("/show/all")
    public Iterable<Books> showBooks(){
        return service.showBooks();
    }

    @GetMapping("/show/{isbn}")
    public Books bookByIsbn(@PathVariable String isbn){
        return  service.bookByIsbn(isbn);
    }

    @GetMapping("/show/author/{author}")
    public Iterable<Books> bookByAuthor(@PathVariable String author){
        return service.bookByAuthor(author);
    }

    @GetMapping("/show/name/{name}")
    public Iterable<Books> bookByName(@PathVariable String name){
        return service.bookByName(name);
    }

    @GetMapping("/show/duration/{start}/{end}")
    public Iterable<Books> booksInDuration(@PathVariable LocalDate start, @PathVariable LocalDate end){
        return service.booksInDuration(start,end);
    }
}
