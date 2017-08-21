package proj.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import proj.entity.Category;
import proj.service.CategoryService;

/**
 * Created by SC on 02.10.2016.
 */
public class CategoryValidator implements Validator {

    private final CategoryService categoryService;

    public CategoryValidator(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Category.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Category form = (Category) o;
        if(form.getId()==0)if(categoryService.findByName(form.getName())!=null){
            errors.rejectValue("name", "", "Category already exists");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
    }
}
