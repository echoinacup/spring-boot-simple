package org.echo.web.contoller;

import org.echo.service.AuthorBooksService;
import org.echo.web.dto.BookDto;
import org.echo.web.mappers.BookMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/authors/{authorId}/books")
public class AuthorBooksController {

    private final AuthorBooksService authorBooksService;
    private final BookMapper mapper;

    public AuthorBooksController(AuthorBooksService authorBooksService, BookMapper mapper) {
        this.authorBooksService = authorBooksService;
        this.mapper = mapper;
    }

    @GetMapping
    public Set<BookDto> findAllBooksByAuthor(@PathVariable Long authorId) {
        return mapper.booksToBooksDto(authorBooksService.findAllBooksByAuthor(authorId));
    }
}
