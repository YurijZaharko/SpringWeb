package proj.service.implementation.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import proj.controller.staticMethod.StaticPatterns;
import proj.form.UsersOrdersForm;

/**
 * Created by SC on 11.03.2017.
 */
public class UsersOrdersFormValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return UsersOrdersForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UsersOrdersForm usersOrdersForm  = (UsersOrdersForm) o;

        if(!StaticPatterns.NAME_PATTERN.matcher(usersOrdersForm.getName()).matches()){
            errors.rejectValue("name", "", "Name must contain only a-z A-Z 0-9 _ + * / -");
        }

        if(!StaticPatterns.NAME_PATTERN.matcher(usersOrdersForm.getSurname()).matches()){
            errors.rejectValue("surname", "", "Surname must contain only a-z A-Z 0-9 _ + * / -");
        }

        if(!StaticPatterns.PHONE_PATTERN.matcher(usersOrdersForm.getPhoneNumber()).matches()){
            errors.rejectValue("phoneNumber", "", "Phone number must be enter in form (123)456-7890");
        }

        if (!StaticPatterns.DIGITAL_PATTERN.matcher(usersOrdersForm.getNewProductId()).matches()){
            errors.rejectValue("newProductId", "", "Must contain only 0-9");
        }

        if (!StaticPatterns.QUANTITY_PATTERN.matcher(usersOrdersForm.getQuantity()).matches()){
            errors.rejectValue("quantity", "", "Only numbers between 1-999999");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newProductId", "", "Field newProductId can't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "", "Field quantity can't be empty");
    }
}
