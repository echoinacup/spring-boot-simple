package org.echo.persistence.model;


import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    // owning side. hat means that it defines the association and the Book entity just references it
    @JoinColumn(name = "author_id")
    private Author author;

    // Hibernate requires no-args constructor
    public Book() {
    }

    public Book(long id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
