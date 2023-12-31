package com.example.LMS.Service;


import com.example.LMS.Users.Books;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServicesAdmin {
    @Autowired
    private com.example.LMS.Repository.bookRepo bookRepo;

    Logger logger= LoggerFactory.getLogger(ServicesAdmin.class);


    public Iterable<Books> showBooks(){
        try{
            return bookRepo.findAll();
        } catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public Books bookByIsbn(String isbn){
        try{
            return bookRepo.findByIsbn(isbn);
        } catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public Iterable<Books> bookByAuthor(String author){
        try{
            return bookRepo.findBooksByAuthor(author);
        } catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public Iterable<Books> bookByName(String name){
        try{
            return bookRepo.findBooksByName(name);
        } catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public Iterable<Books> booksInDuration(LocalDate start,LocalDate end){
        try{
            return bookRepo.findBooksByDuration(start, end);
        } catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public void addBook(String isbn,String name, String author, LocalDate issue_date,int copies){
        try{
            Books new_book = new Books(isbn, name, author, issue_date, copies);
            bookRepo.save(new_book);
            logger.info("Book Added");
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }
    public void removeBook(String isbn){
        try{
            bookRepo.deleteByIsbn(isbn);
            logger.info("Book Removed");
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }

}
