package com.example.librarymanagementsystem.entity;


import jakarta.persistence.*;
import lombok.*;

@Setter
@AllArgsConstructor
@Getter
@Data
@Table(name = "Book")
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private boolean available = true;

    // Constructors, getters, and setters
    public BookEntity() {}

    public BookEntity(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

}

