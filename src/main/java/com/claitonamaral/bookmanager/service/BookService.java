package com.claitonamaral.bookmanager.service;

import com.claitonamaral.bookmanager.dto.MessageResponseDTO;
import com.claitonamaral.bookmanager.entity.Book;
import com.claitonamaral.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){

        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(Book book){
        Book saveBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + saveBook.getId())
                .build();
    }
}
