package com.example.LMS.Repository;

import com.example.LMS.Users.Books;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface bookRepo extends CrudRepository<Books, String> {
    @Query("SELECT b FROM Books b WHERE b.author = :author")
    Iterable<Books> findBooksByAuthor(String author);

    @Query("SELECT b FROM Books b WHERE b.name = :name")
    Iterable<Books> findBooksByName(String name);

    @Query("SELECT b FROM Books b WHERE b.isbn = :isbn")
    Books findByIsbn(String isbn);

    @Transactional
    @Modifying
    @Query("DELETE FROM Books b WHERE b.isbn = :isbn")
    void deleteByIsbn(@Param("isbn") String isbn);

    @Query("SELECT b FROM Books b WHERE b.issue_date BETWEEN :start AND :end")
    Iterable<Books> findBooksByDuration(LocalDate start, LocalDate end);

}
