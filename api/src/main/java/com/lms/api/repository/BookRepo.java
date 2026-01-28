package com.lms.api.repository;

import com.lms.api.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    @Query(value = "Select b FROM Book WHERE b.libraryId= :libraryId")
    List<Book> findAllByLibraryId(@Param("libraryId") Long libraryId);
}
