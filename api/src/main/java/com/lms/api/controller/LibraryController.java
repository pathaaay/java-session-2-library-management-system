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
    LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/all")
    public List<LibraryDTO> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/{libraryId}")
    public LibraryDTO getLibraryById(@PathVariable long libraryId) {
        return libraryService.getLibraryById(libraryId);
    }

    @PostMapping()
    public LibraryDTO createLibrary(@RequestBody Library library) {
        return libraryService.createLibrary(library);

    }

    @DeleteMapping("/{libraryId}")
    public boolean deleteLibraryById(@PathVariable long libraryId) {
        return libraryService.deleteLibrary(libraryId);
    }

}
