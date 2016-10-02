package proj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.entity.Category;
import proj.entity.StringProperties;
import proj.form.Filter.CategoryFilterForm;

import java.util.List;

/**
 * Created by SCIP on 11.08.2016.
 */

public interface CategoryService{
    void save(String name);

    void save(String name, String parentName);

    Category findByName(String name);

    Category findById(int id);

    void deleteById(int id);
    List<Category> findAll();

    void save(Category category);

    List<Category> findAllWithProperty(int id);

    List<Category> findAllWithProperty();

    Category findByIdWithAllFetch(int id);


    List<Category> findByIdWithCategoryChild(int id);

    Page<Category> findAll(Pageable pageable, CategoryFilterForm categoryFilterForm);

    void savePropertyToCategory(Pageable pageable, CategoryFilterForm categoryFilterForm, int catId, int id);
}
