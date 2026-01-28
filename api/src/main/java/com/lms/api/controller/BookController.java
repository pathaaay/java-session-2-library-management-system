package com.lms.api.controller;

import com.lms.api.dto.BookDTO;
import com.lms.api.entities.Author;
import com.lms.api.entities.Book;
import com.lms.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<BookDTO> getAuthors() {
        return bookService.getBooks();
    }

    @GetMapping("/{bookId}")
    public BookDTO getAuthorById(@PathVariable long bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping()
    public BookDTO createAuthor(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @DeleteMapping("/{bookId}")
    public boolean deleteAuthorById(@PathVariable long bookId) {
        return bookService.deleteBookById(bookId);
    }

}
