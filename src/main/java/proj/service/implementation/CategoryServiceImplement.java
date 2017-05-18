package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proj.entity.Category;
import proj.entity.StringProperties;
import proj.form.Filter.CategoryFilterForm;
import proj.repository.CategoryRepository;
import proj.repository.StringPropertiesRepository;
import proj.service.CategoryService;
import proj.service.implementation.specification.CategoryFilterAdapter;

import java.util.List;

/**
 * Created by SCIP on 11.08.2016.
 */
@Service
public class CategoryServiceImplement implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StringPropertiesRepository stringPropertiesRepository;

    @Override
    public void save(String name) {
        if (categoryRepository.findByName(name) == null){
            Category category = new Category(name);
            categoryRepository.save(category);
        }

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
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllWithProperty(int id) {
        return categoryRepository.findAllWithProperty(id);
    }

    @Override
    public List<Category> findAllWithProperty() {
        return categoryRepository.findAllWithProperty();
    }

    @Override
    public Category findByIdWithAllFetch(int id) {
        return categoryRepository.findByIdWithAllFetch(id);
    }

    @Override
    public List<Category> findByIdWithCategoryChild(int id) {
        return categoryRepository.findByIdWithCategoryChild(id);
    }

    @Override
    public Page<Category> findAll(Pageable pageable, CategoryFilterForm categoryFilterForm) {
        return categoryRepository.findAll(new CategoryFilterAdapter(categoryFilterForm), pageable);
    }

    @Override
    public void savePropertyToCategory(Pageable pageable, CategoryFilterForm categoryFilterForm, int catId, int id) {
        Category category = categoryRepository.findByIdWithAllFetch(catId);
        category.getStringPropertiesList().add(stringPropertiesRepository.findById(id));
        categoryRepository.save(category);
    }

    @Override
    public void removePropertyFromCategory(Pageable pageable, CategoryFilterForm categoryFilterForm, int catId, int id) {
        Category category = categoryRepository.findByIdWithAllFetch(catId);
        StringProperties stringProperties = stringPropertiesRepository.findById(id);
        category.getStringPropertiesList().remove(stringProperties);
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findByRootCategoryTrue() {
        return categoryRepository.findByRootCategoryTrue();
    }

    @Override
    public Category findByIdFetchParentId(int id) {
        return categoryRepository.findByIdFetchParentId(id);
    }

    @Override
    public List<Category> findByRootCategoryTrueFetchChild() {
        return categoryRepository.findByRootCategoryTrueFetchChild();
    }
}
