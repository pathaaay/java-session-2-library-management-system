package com.lms.api.service;

import com.lms.api.dto.AuthorDTO;
import com.lms.api.entities.Author;
import com.lms.api.mapper.EntityMapper;
import com.lms.api.repository.AuthorRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private EntityMapper entityMapper;

    @Transactional()
    public List<AuthorDTO> getAuthors() {
        List<Author> data = authorRepo.findAll();
        return entityMapper.toAuthorDTOList(data);
    }

    @Transactional()
    public AuthorDTO getAuthorById(Long id) {
        Optional<Author> data = authorRepo.findById(id);
        return entityMapper.toAuthorDTO(data.orElse(null));
    }

    @Transactional()
    public AuthorDTO createAuthor(Author author) {
        Author data = authorRepo.save(author);
        return entityMapper.toAuthorDTO(data);
    }

    @Transactional()
    public boolean deleteAuthorById(Long id) {
        try {
            authorRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
