package com.lms.api.service;

import com.lms.api.dto.LibraryDTO;
import com.lms.api.entities.Library;
import com.lms.api.mapper.EntityMapper;
import com.lms.api.repository.LibraryRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private EntityMapper entityMapper;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional()
    public List<LibraryDTO> getAllLibraries() {
        List<Library> libraries = libraryRepo.findAll();
        return entityMapper.toLibraryDTOList(libraries);
    }

    @Transactional()
    public LibraryDTO createLibrary(Library library) {
        Library newLibrary = libraryRepo.save(library);
        return entityMapper.toLibraryDTO(newLibrary);
    }
}
