package org.echo.service;

import org.echo.persistence.model.Author;
import org.echo.persistence.repo.AuthorRepo;
import org.echo.web.exception.AuthorNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepo repo;

    public AuthorService(AuthorRepo repo) {
        this.repo = repo;
    }

    public Author findAuthorById(Long id) {
        return repo.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author with given id not found"));
    }
}
