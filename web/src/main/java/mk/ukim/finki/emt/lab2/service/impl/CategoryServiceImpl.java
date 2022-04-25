package mk.ukim.finki.emt.lab2.service.impl;

import mk.ukim.finki.emt.lab2.model.Category;
import mk.ukim.finki.emt.lab2.model.enumerations.CategoryBook;
import mk.ukim.finki.emt.lab2.repository.jpa.CategoryRepository;
import mk.ukim.finki.emt.lab2.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(CategoryBook name) {
        if (name==null) {
            throw new IllegalArgumentException();
        }
        Category c = new Category(name);
        categoryRepository.save(c);
        return c;
    }

    @Override
    public Category update(CategoryBook name) {
        if (name==null) {
            throw new IllegalArgumentException();
        }
        Category c= new Category(name);
        categoryRepository.save(c);
        return c;
    }

    @Override
    public void delete(CategoryBook name) {
        if (name==null) {
            throw new IllegalArgumentException();
        }
        categoryRepository.deleteByName(String.valueOf(name));
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> searchCategories(String searchText) {
        return categoryRepository.findAllByNameLike(searchText);
    }

}
