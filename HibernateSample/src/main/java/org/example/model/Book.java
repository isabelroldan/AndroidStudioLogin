package org.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="BOOK")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ISBN")
    private String isbn;

    @Column(name="TITLE")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_AUTHOR")
    private Author author;

    public Book() {
    }

    public Book(String isbn, String title, Author author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    // Getters y Setters omitidos por brevedad

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author.getName() +
                '}';
    }
}
