package proj.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import proj.entity.Brand;
import proj.service.BrandService;

/**
 * Created by SCIP on 07.09.2016.
 */
public class BrandValidator implements Validator {

    private final BrandService brandService;

    public BrandValidator(BrandService brandService) {
        this.brandService = brandService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Brand.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Brand brand = (Brand) o;
        if (brand.getName() == null){
            errors.rejectValue("name", "Can't be empty");
        }
        if(brand.getId() == 0) if(brandService.findByName(brand.getName()) != null){
            errors.rejectValue("name", "", "Brand already exists");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can't be empty");
    }
}
