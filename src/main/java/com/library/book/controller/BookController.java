package com.library.book.controller;

import com.library.book.model.Books;
import com.library.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository repo;


    //Crud operation
    //create
    @PostMapping("/bookSave")
    public String insertBook(@RequestBody  Books books)
    {
        repo.save(books);
        return books+"Book has been saved";
    }

    @PostMapping("/multipleBookSave")
    public String insertBook(@RequestBody List<Books> books)
    {
        repo.saveAll(books);
        return books+"Multiple Books has been saved";
    }


    // read
    @GetMapping("/getAll")
    public List<Books> showAll()
    {
        return (List<Books>) repo.findAll();
    }
// update....
    // search
    @GetMapping("/getBookByName/{name}")
    public List<Books>getBookByName(@PathVariable("name") String bookName)
    {
        return (List<Books>) repo.findBybookName(bookName);
    }

    @GetMapping("/getBookById/{bookId}")
    public Optional<Books> getBookById(@PathVariable("bookId") long id)
    {
        return repo.findById(id);
    }

    // edit and update in springboot mysql

    @PutMapping("/update")
    public Books updateById(@RequestBody() Books books)
    {
        return repo.save(books);
    }

    // update all at a time

    @PutMapping("/updateAll")
    public List<Books> updateAllById(@RequestBody()  List<Books> books)
    {
        return repo.saveAll(books);
    }




    // delete by id and name
    @DeleteMapping("/deleteById/{bookId}")
    public String deleteById(@PathVariable("bookId") long id)
    {
        repo.deleteById(id);
        return "Book with id "+id+" is deleted from Library Successfully...";

    }






}
