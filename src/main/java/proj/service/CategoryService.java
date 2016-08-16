package proj.service;

import proj.entity.Category;

import java.util.List;

/**
 * Created by SCIP on 11.08.2016.
 */

public interface CategoryService {
    void save(String name);
    void save(String name, String parentName);
    Category findByName(String name);
    Category findById(int id);
    void delete(String name);
    List<Category> findAll();
}
