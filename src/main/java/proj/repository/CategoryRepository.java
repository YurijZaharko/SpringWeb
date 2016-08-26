package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.Category;

/**
 * Created by SC on 10.08.2016.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);

    Category findById(int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Category category WHERE category.id=:id")
    void deleteById(@Param("id") int id);
}
