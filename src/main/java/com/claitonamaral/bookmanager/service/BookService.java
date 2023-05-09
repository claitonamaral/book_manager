package com.claitonamaral.bookmanager.service;

import com.claitonamaral.bookmanager.dto.BookDTO;
import com.claitonamaral.bookmanager.dto.MessageResponseDTO;
import com.claitonamaral.bookmanager.entity.Book;
import com.claitonamaral.bookmanager.exception.BookNotFoundException;
import com.claitonamaral.bookmanager.mapper.BookMapper;
import com.claitonamaral.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookMapper bookMapper = BookMapper.INSTANCE;
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {

        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);

        return MessageResponseDTO.builder()
                .message("Book created with ID: " + savedBook.getId())
                .build();
    }

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }
}
