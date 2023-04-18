package org.echo.web.contoller;


import org.echo.persistence.model.Book;
import org.echo.service.BookService;
import org.echo.web.dto.BookDto;
import org.echo.web.mappers.BookMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper mapper;

    public BookController(BookService bookService, BookMapper mapper) {
        this.bookService = bookService;
        this.mapper = mapper;
    }

    @GetMapping
    public Iterable<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List<Book> findByTitle(@PathVariable String bookTitle) {
        return bookService.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public BookDto findOne(@PathVariable Long id) {
        var book = bookService.findBookById(id);
        return mapper.bookToBookDto(book);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto create(@RequestBody BookDto book) {
        var createdBook = bookService.creatBook(book);
        return mapper.bookToBookDto(createdBook);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@RequestBody BookDto book, @PathVariable Long id) {
        var updatedBook = bookService.updateBook(id, book);
        return mapper.bookToBookDto(updatedBook);
    }
}
