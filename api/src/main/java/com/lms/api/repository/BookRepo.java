package com.lms.api.repository;

import com.lms.api.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    @Query("Select b FROM Book b WHERE b.library.id=:libraryId")
    List<Book> findAllBooksByLibraryId(@Param("libraryId") Long libraryId);

    @Query("Select b FROM Book b WHERE b.author.id=:authorId")
    List<Book> findAllBooksByAuthorId(@Param("authorId") Long authorId);
}
