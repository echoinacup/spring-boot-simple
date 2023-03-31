package org.echo.persistence.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Column(name = "author_name", nullable = false, unique = true)
    private String authorName;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

    public Author(String authorName) {
        this.authorName = authorName;
    }

    public void addBook(Book book) {
        this.books.add(book);
        book.setAuthor(this);
    }

    public void deleteBook(Book book) {
        this.books.remove(book);
        book.setAuthor(null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
