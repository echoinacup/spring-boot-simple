package org.echo.web.contoller;

import org.echo.service.AuthorService;
import org.echo.web.dto.AuthorDto;
import org.echo.web.mappers.AuthorMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper mapper;

    public AuthorController(AuthorService authorService, AuthorMapper mapper) {
        this.authorService = authorService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public AuthorDto findOne(@PathVariable Long id) {
        return mapper.authorToAuthorDtO(authorService.findAuthorById(id));
    }
}
