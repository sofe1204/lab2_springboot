package mk.ukim.finki.emt.lab2.web.rest;

import mk.ukim.finki.emt.lab2.model.Category;

import mk.ukim.finki.emt.lab2.service.CategoryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/categories")
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll() {
        return this.categoryService.listCategories();
    }


//    @PostMapping("/add")
//    public ResponseEntity<Author> save(@RequestParam CategoryBook name) {
//        return this.categoryService.save(name)
//                .map(author -> ResponseEntity.ok().body(author))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteById(@PathVariable Long id) {
//        this.categoryService.deleteById(id);
//        if(this.categoryService.findById(id).isEmpty()) return ResponseEntity.ok().build();
//        return ResponseEntity.badRequest().build();
//}
}
