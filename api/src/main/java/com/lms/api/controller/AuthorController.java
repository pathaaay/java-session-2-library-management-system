package com.lms.api.controller;

import com.lms.api.dto.AuthorDTO;
import com.lms.api.dto.LibraryDTO;
import com.lms.api.entities.Author;
import com.lms.api.entities.Library;
import com.lms.api.service.AuthorService;
import com.lms.api.service.LibraryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public List<AuthorDTO> getAuthors() {
        return authorService.getAuthors();
    }

    @GetMapping("/{authorId}")
    public AuthorDTO getAuthorById(@PathVariable long authorId) {
        return authorService.getAuthorById(authorId);
    }

    @PostMapping()
    public AuthorDTO createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @DeleteMapping("/{authorId}")
    public boolean deleteAuthorById(@PathVariable long authorId) {
        return authorService.deleteAuthorById(authorId);
    }

}
