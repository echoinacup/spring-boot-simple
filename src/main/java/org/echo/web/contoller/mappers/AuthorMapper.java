package org.echo.web.contoller.mappers;

import org.echo.persistence.model.Author;
import org.echo.persistence.model.Book;
import org.echo.web.contoller.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface AuthorMapper {


    @Mapping(target = "bookTitles", source = "books")
    AuthorDto authorToAuthorDtO(Author entity);

    default String booksToBookTitles(Book book){
         return book != null ? book.getTitle() : null;
    }


    Author authorDtoToAuthor(AuthorDto dto);
}
