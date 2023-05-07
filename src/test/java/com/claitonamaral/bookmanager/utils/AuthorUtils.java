package com.claitonamaral.bookmanager.utils;

import com.claitonamaral.bookmanager.dto.AuthorDTO;
import com.claitonamaral.bookmanager.entity.Author;
import net.datafaker.Faker;

public class AuthorUtils {

    private static final Faker faker = Faker.instance();

    public static AuthorDTO createFakeAuthorDTO(){
        return AuthorDTO.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().author())
                .age(faker.number().numberBetween(0,100))
                .build();
    }

    public static Author createFakeAuthor(){
        return Author.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().author())
                .age(faker.number().numberBetween(0,100))
                .build();
    }
}
