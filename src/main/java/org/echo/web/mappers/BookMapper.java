package org.echo.web.mappers;

import org.echo.persistence.model.Book;
import org.echo.web.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;


@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "authorName", source = "entity.author.authorName")
    BookDto bookToBookDto(Book entity);

    Book bookDtoToBook(BookDto dto);

    @Mapping(target = "authorName", source = "entity.author.authorName")
    Set<BookDto> booksToBooksDto(Set<Book> entities);

}
