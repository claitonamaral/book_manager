package com.claitonamaral.bookmanager.utils;

import com.claitonamaral.bookmanager.dto.BookDTO;
import com.claitonamaral.bookmanager.entity.Book;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.datafaker.Faker;

import static com.claitonamaral.bookmanager.utils.AuthorUtils.createFakeAuthor;
import static com.claitonamaral.bookmanager.utils.AuthorUtils.createFakeAuthorDTO;

public class BookUtils {

    private static final Faker faker = Faker.instance();

    public static BookDTO createFakeBookDTO(){
        return BookDTO.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .pages(faker.number().numberBetween(0,200))
                .chapters(faker.number().numberBetween(1,20))
                .isbn("0-596-52068-9")
                .publisherName(faker.book().publisher())
                .author(createFakeAuthorDTO())
                .build();
    }

    public static Book createFakeBook(){
        return Book.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .pages(faker.number().numberBetween(0,200))
                .chapters(faker.number().numberBetween(1,20))
                .isbn("0-596-52068-9")
                .publisherName(faker.book().publisher())
                .author(createFakeAuthor())
                .build();
    }

    public static String asJsonString(BookDTO bookDTO) {

        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());

            return objectMapper.writeValueAsString(bookDTO);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
