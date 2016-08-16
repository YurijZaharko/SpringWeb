package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.Category;
import proj.repository.CategoryRepository;
import proj.service.CategoryService;

import java.util.List;

/**
 * Created by SCIP on 11.08.2016.
 */
@Service
public class CategoryServiceImplement implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void save(String name) {
        categoryRepository.save(new Category(name));
    }

    @Override
    public void save(String name, String parentName) {
        categoryRepository.save(new Category(name, categoryRepository.findByName(parentName)));
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void delete(String name) {
        categoryRepository.deleteByName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
