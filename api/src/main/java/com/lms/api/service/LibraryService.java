package com.lms.api.service;

import com.lms.api.dto.LibraryDTO;
import com.lms.api.entities.Library;
import com.lms.api.mapper.EntityMapper;
import com.lms.api.repository.LibraryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private EntityMapper entityMapper;

    @Transactional()
    public List<LibraryDTO> getAllLibraries() {
        List<Library> data = libraryRepo.findAll();
        return entityMapper.toLibraryDTOList(data);
    }

    @Transactional()
    public LibraryDTO getLibraryById(Long id) {
        Optional<Library> library = libraryRepo.findById(id);
        return entityMapper.toLibraryDTO(library.orElse(null));
    }

    @Transactional()
    public LibraryDTO createLibrary(Library library) {
        Library data = libraryRepo.save(library);
        return entityMapper.toLibraryDTO(data);
    }

    @Transactional()
    public boolean deleteLibrary(Long id) {
        try {
            libraryRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
