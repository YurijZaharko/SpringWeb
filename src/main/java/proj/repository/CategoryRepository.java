package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.Category;

import java.util.List;

/**
 * Created by SC on 10.08.2016.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {
    Category findByName(String name);

    Category findById(int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Category category WHERE category.id=:id")
    void deleteById(@Param("id") int id);

    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.stringPropertiesList WHERE c.id=:id")
    List<Category> findAllWithProperty(@Param("id") int id);

    @Query("SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.stringPropertiesList")
    List<Category> findAllWithProperty();

    @Query("SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.stringPropertiesList WHERE c.id=:id")
    Category findByIdWithAllFetch(@Param("id") int id);

    @Query("SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.categoryChild WHERE c.id=:id")
    List<Category> findByIdWithCategoryChild(@Param("id") int id);

    List<Category> findByRootCategoryTrue();

    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.parentId WHERE c.id=:id")
    Category findByIdFetchParentId(@Param("id") int id);

    @Query("SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.categoryChild cc WHERE c.rootCategory = TRUE")
    List<Category> findByRootCategoryTrueFetchChild();
}
