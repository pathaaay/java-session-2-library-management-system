package com.lms.api.mapper;

import com.lms.api.dto.AuthorDTO;
import com.lms.api.dto.BookDTO;
import com.lms.api.dto.LibraryDTO;
import com.lms.api.entities.Author;
import com.lms.api.entities.Book;
import com.lms.api.entities.Library;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMapper {

    //    Library Entity Mapper
    public LibraryDTO toLibraryDTO(Library library) {
        if (library == null) {
            return null;
        }

        LibraryDTO libraryDTO = new LibraryDTO();

        libraryDTO.setId(library.getId());
        libraryDTO.setName(library.getName());
        libraryDTO.setCreatedAt(library.getCreatedAt());
        libraryDTO.setUpdatedAt(library.getUpdatedAt());

        return libraryDTO;
    }

    public List<LibraryDTO> toLibraryDTOList(List<Library> libraries) {
        return libraries.stream()
                .map(this::toLibraryDTO)
                .collect(Collectors.toList());
    }


    //    Book Entity Mapper
    public BookDTO toBookDTO(Book book) {
        if (book == null) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId(book.getId());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setCreatedAt(book.getCreatedAt());
        bookDTO.setUpdatedAt(book.getUpdatedAt());
        bookDTO.setPublication_year(book.getPublication_year());
        return bookDTO;
    }

    public List<BookDTO> toBookDTOList(List<Book> books) {
        return books.stream()
                .map(this::toBookDTO)
                .collect(Collectors.toList());
    }


    //    Author Entity Mapper
    public AuthorDTO toAuthorDTO(Author author) {
        if (author == null) {
            return null;
        }
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());
        authorDTO.setCreatedAt(author.getCreatedAt());
        authorDTO.setUpdatedAt(author.getUpdatedAt());
        authorDTO.setBiography(author.getBiography());
        return authorDTO;
    }

    public List<AuthorDTO> toAuthorDTOList(List<Author> authors) {
        return authors.stream()
                .map(this::toAuthorDTO)
                .collect(Collectors.toList());
    }
}
