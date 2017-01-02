package proj.service.implementation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import proj.entity.User;
import proj.service.UserService;

/**
 * Created by SC on 29.12.2016.
 */
public class UserValidator implements Validator {

    private  final UserService userService;

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
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "", "Field Login can't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Field password can't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Field name can't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "", "Field name can't be empty");
    }
}
