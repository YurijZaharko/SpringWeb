package proj.service;

import proj.entity.Category;

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
}
