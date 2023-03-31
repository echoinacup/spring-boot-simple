package org.echo.service;


import org.echo.persistence.model.Book;
import org.echo.persistence.repo.BookRepository;
import org.echo.web.contoller.dto.BookDto;
import org.echo.web.exception.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public Book creatBook(BookDto newBook) {
        var book = new Book();
        book.setTitle(newBook.title());
        var author = authorService.findAuthorByNameElseCreateNew(newBook.authorName());
        book.setAuthor(author);
        var savedBook = bookRepository.save(book);
        author.addBook(savedBook);
        // todo should I save an author as well ???
        return savedBook;
    }

    public Book updateBook(long id, BookDto newBook) {
        if (bookRepository.findById(id).isPresent()) {
            var existingBook = bookRepository.findById(id).get();
            existingBook.setTitle(newBook.title());
            //TODO author later???
            //existingBook.setAuthor();
            return bookRepository.save(existingBook);
        }
        return null; // TODO don't like it
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByTitle(String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
