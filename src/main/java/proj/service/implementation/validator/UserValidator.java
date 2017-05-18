package proj.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import proj.controller.staticMethod.StaticPatterns;
import proj.entity.User;
import proj.service.UserService;

/**
 * Created by SC on 29.12.2016.
 */
public class UserValidator implements Validator {

    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User form = (User) o;
        if (form.getId()==0)if (userService.findByLogin(form.getLogin())!=null){
            errors.rejectValue("login", "", "User already registered");
        } else if (!StaticPatterns.EMAIL_PATTERN.matcher(form.getLogin()).matches()){
            errors.rejectValue("login", "", "Email incorrect");
        }

        if(!StaticPatterns.NAME_PATTERN.matcher(form.getName()).matches()){
            errors.rejectValue("name", "", "Name must contain only a-z A-Z 0-9 _ + * / -");
        }

        if(!StaticPatterns.NAME_PATTERN.matcher(form.getSurname()).matches()){
            errors.rejectValue("surname", "", "Surname must contain only a-z A-Z 0-9 _ + * / -");
        }

        if(!StaticPatterns.PHONE_PATTERN.matcher(form.getPhoneNumber()).matches()){
            errors.rejectValue("phoneNumber", "", "Phone number must be enter in form (123)456-7890");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "", "Field Login can't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Field password can't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Field name can't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "", "Field name can't be empty");
    }
}
