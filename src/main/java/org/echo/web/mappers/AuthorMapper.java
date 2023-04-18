package org.echo.web.mappers;

import org.echo.persistence.model.Author;
import org.echo.persistence.model.Book;
import org.echo.web.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface AuthorMapper {


    @Mapping(target = "bookTitles", source = "books")
    AuthorDto authorToAuthorDtO(Author entity);

    default Set<String> booksToBookTitles(Set<Book> books) {
        return books == null ? null : books.stream().map(Book::getTitle).collect(Collectors.toSet());
    }


    Author authorDtoToAuthor(AuthorDto dto);
}
