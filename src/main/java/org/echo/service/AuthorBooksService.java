package org.echo.service;

import org.echo.persistence.model.Book;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthorBooksService {

    private final AuthorService authorService;

    public AuthorBooksService(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Set<Book> findAllBooksByAuthor(long authorId) {
        return authorService.findAuthorById(authorId).getBooks();
    }
}
