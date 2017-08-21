package proj.service.implementation.editor;

import proj.entity.Category;
import proj.service.CategoryService;

import java.beans.PropertyEditorSupport;

/**
 * Created by SC on 04.09.2016.
 */
public class CategoryEditor extends PropertyEditorSupport{
    private final CategoryService categoryService;

    public CategoryEditor(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Category category = categoryService.findById(Integer.valueOf(text));
        setValue(category);
    }
}
