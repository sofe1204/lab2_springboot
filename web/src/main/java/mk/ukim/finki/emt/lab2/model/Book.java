package mk.ukim.finki.emt.lab2.model;

import lombok.Data;
import mk.ukim.finki.emt.lab2.model.enumerations.CategoryBook;

import javax.persistence.*;

@Data
@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book(){}
    public Book( String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }


}
