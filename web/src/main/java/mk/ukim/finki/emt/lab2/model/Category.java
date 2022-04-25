package mk.ukim.finki.emt.lab2.model;

import lombok.Data;
import mk.ukim.finki.emt.lab2.model.enumerations.CategoryBook;

import javax.persistence.*;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryBook name;


    public Category() {
    }

    public Category(CategoryBook name) {
        this.name = name;
    }
}
