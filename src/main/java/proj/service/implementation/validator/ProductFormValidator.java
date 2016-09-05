package proj.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import proj.form.ProductForm;
import proj.service.ProductService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by SC on 05.09.2016.
 */
public class ProductFormValidator implements Validator {

    private final ProductService productService;


    public ProductFormValidator(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return ProductForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductForm form = (ProductForm) o;
        if(form.getId()==0)if (productService.findByName(form.getProductName())!=null){
            errors.rejectValue("productName", "","Product already exists");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "", "Can`t be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "partNumber", "", "Can`t be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "", "Can`t be empty");
    }
}
