package com.booleanuk.api.book;

import com.booleanuk.api.author.Author;
import com.booleanuk.api.publisher.Publisher;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String genre;

    @ManyToOne
    @JoinColumn(name ="author_id", nullable = false)
    @JsonIncludeProperties(value = {"firstName", "lastName", "email", "alive"})
    private Author author;

    @ManyToOne
    @JoinColumn(name ="publisher_id", nullable = false)
    @JsonIncludeProperties(value = {"name", "location"})
    private Publisher publisher;

    public Book(String title, String genre, Author author, Publisher publisher) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
    }
}
