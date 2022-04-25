//package mk.ukim.finki.emt.lab2.data;
//
//
//import mk.ukim.finki.emt.lab2.model.Category;
//import mk.ukim.finki.emt.lab2.model.Country;
//import mk.ukim.finki.emt.lab2.model.enumerations.CategoryBook;
//import mk.ukim.finki.emt.lab2.service.AuthorService;
//import mk.ukim.finki.emt.lab2.service.BookService;
//import mk.ukim.finki.emt.lab2.service.CategoryService;
//import mk.ukim.finki.emt.lab2.service.CountryService;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Component
//public class DataInitializer {
//    private final BookService bookService;
//    private final AuthorService authorService;
//    private final CountryService countryService;
//    private final CategoryService categoryService;
//
//    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService, CategoryService categoryService) {
//        this.bookService = bookService;
//        this.authorService = authorService;
//        this.countryService = countryService;
//        this.categoryService = categoryService;
//    }
//    private CategoryBook randomizeCategory(int i) {
//        if (i == 0) return CategoryBook.NOVEL;
//        else if (i  == 1) return CategoryBook.THRILLER;
//        else if (i == 2) return CategoryBook.HISTORY;
//        else if (i == 3) return CategoryBook.FANTASY;
//        else if (i == 4) return CategoryBook.BIOGRAPHY;
//        else if (i  == 5) return CategoryBook.CLASSICS;
//        return CategoryBook.DRAMA;
//    }
//
//    @PostConstruct
//    public void initData()
//    {
//
//        for (int i = 1; i < 5; i++) {
//            this.countryService.save("Country"+i,"Continent"+i);
//        }
//        Country country = new Country("Japan","Asia");
//
//        for (int i = 1; i < 6; i++) {
//            this.authorService.save("Author"+i,"Author"+i,country);
//        }
//        List<Category> categories = this.categoryService.listCategories();
//
//        for (int i = 1; i < 11; i++) {
//            this.bookService.save("Name"+i, this.categoryService.listCategories().get((i - 1) % 5).getId()
//                    ,this.authorService.findAll().get((i - 1) % 5).getId(),20 * i);
//        }
//
//    }
//
//}
