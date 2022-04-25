package emt.lab2backend.model;


import emt.lab2backend.model.ENUM.Category;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Author author;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    private Integer availableCopies;

    public Book() {
    }

    public Book(String name, Author author, Category category, Integer availableCopies) {

        this.name = name;
        this.author = author;
        this.category = category;
        this.availableCopies = availableCopies;
    }

    public void MarkAsTaken(){
        this.availableCopies--;
    }

}
