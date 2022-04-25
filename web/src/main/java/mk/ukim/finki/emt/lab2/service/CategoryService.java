package mk.ukim.finki.emt.lab2.service;


import mk.ukim.finki.emt.lab2.model.Category;
import mk.ukim.finki.emt.lab2.model.enumerations.CategoryBook;

import java.nio.channels.FileChannel;
import java.util.List;

public interface CategoryService {

    Category create(CategoryBook name);

    Category update(CategoryBook name);

    void delete(CategoryBook name);

    List<Category> listCategories();

    List<Category> searchCategories(String searchText);

}
