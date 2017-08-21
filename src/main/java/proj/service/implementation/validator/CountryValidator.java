package proj.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import proj.entity.Country;
import proj.service.CountryService;

/**
 * Created by SCIP on 12.09.2016.
 */
public class CountryValidator implements Validator {

    private final CountryService countryService;

    public CountryValidator(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Country.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Country form = (Country) o;
        if(form.getId()==0)if(countryService.findByName(form.getName())!=null){
            errors.rejectValue("name", "", "Country already exists");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Can`t be empty");
    }
}
