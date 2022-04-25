package mk.ukim.finki.emt.lab2.repository.jpa;

import mk.ukim.finki.emt.lab2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByNameLike(String text);

    void deleteByName(String name);
}
