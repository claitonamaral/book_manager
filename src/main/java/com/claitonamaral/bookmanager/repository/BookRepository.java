package com.claitonamaral.bookmanager.repository;

import com.claitonamaral.bookmanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
