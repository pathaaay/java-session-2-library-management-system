package com.lms.api.repository;

import com.lms.api.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long> {
    @Query("SELECT l from Library l INNER JOIN books b ON b.id = :bookId")
    Library findLibraryByBookId(@Param("bookId") Long bookId);
}
