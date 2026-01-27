package com.lms.api.controller;

import com.lms.api.dto.LibraryDTO;
import com.lms.api.entities.Library;
import com.lms.api.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private final LibraryService libraryService;

    @Autowired
    LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }

    @GetMapping()
    public List<LibraryDTO> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @PostMapping()
    public LibraryDTO createLibrary(@RequestBody Library library){
        return libraryService.createLibrary(library);
    }
}
