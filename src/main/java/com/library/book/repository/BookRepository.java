package com.library.book.repository;

import com.library.book.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Books,Long> {
    public List<Books>findBybookName(String bookName);


}
