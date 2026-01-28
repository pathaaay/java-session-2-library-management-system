package com.lms.api.controller;

import com.lms.api.dto.BookDTO;
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
    public List<BookDTO> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{bookId}")
    public BookDTO getBookById(@PathVariable long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping("/library/{libraryId}")
    public List<BookDTO> getBookByLibraryId(@PathVariable long libraryId) {
        return bookService.getBooksByLibraryId(libraryId);
    }

    @GetMapping("/author/{authorId}")
    public List<BookDTO> getBookByAuthorId(@PathVariable long authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }

    @PostMapping()
    public BookDTO createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @DeleteMapping("/{bookId}")
    public boolean deleteBookById(@PathVariable long bookId) {
        return bookService.deleteBookById(bookId);
    }

}
