package com.lms.api.service;

import com.lms.api.dto.BookDTO;
import com.lms.api.entities.Author;
import com.lms.api.entities.Book;
import com.lms.api.entities.Library;
import com.lms.api.mapper.EntityMapper;
import com.lms.api.repository.AuthorRepo;
import com.lms.api.repository.BookRepo;
import com.lms.api.repository.LibraryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private LibraryRepo libraryRepo;
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private EntityMapper entityMapper;

    @Transactional()
    public List<BookDTO> getBooks() {
        List<Book> data = bookRepo.findAll();
        return entityMapper.toBookDTOList(data);
    }

    @Transactional()
    public BookDTO getBookById(Long id) {
        Optional<Book> data = bookRepo.findById(id);
        return entityMapper.toBookDTO(data.orElse(null));
    }

    @Transactional()
    public BookDTO createBook(Book book) {
        System.out.println("Library id" + book.getLibrary_id());
        System.out.println("Author id" + book.getAuthor_id());

        Optional<Library> library = libraryRepo.findById(book.getLibrary_id());
        Optional<Author> author = authorRepo.findById(book.getAuthor_id());
        System.out.println("library" + library);
        System.out.println("author" + author);
        book.setLibrary(library.orElse(null));
        book.setAuthor(author.orElse(null));
        Book data = bookRepo.save(book);
        return entityMapper.toBookDTO(data);
    }

    @Transactional()
    public boolean deleteBookById(Long id) {
        try {
            bookRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
