package com.claitonamaral.bookmanager.service;

import com.claitonamaral.bookmanager.dto.BookDTO;
import com.claitonamaral.bookmanager.dto.MessageResponseDTO;
import com.claitonamaral.bookmanager.entity.Book;
import com.claitonamaral.bookmanager.mapper.BookMapper;
import com.claitonamaral.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository){

        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO){

        Book bookToSave = BookMapper.INSTANCE.toModel(bookDTO);

        Book saveBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + saveBook.getId())
                .build();
    }
}
