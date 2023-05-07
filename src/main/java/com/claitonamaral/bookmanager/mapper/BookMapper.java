package com.claitonamaral.bookmanager.mapper;

import com.claitonamaral.bookmanager.dto.BookDTO;
import com.claitonamaral.bookmanager.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
