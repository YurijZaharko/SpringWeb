package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proj.entity.Role;
import proj.entity.User;
import proj.service.UserService;
import proj.service.implementation.validator.UserValidator;

import javax.validation.Valid;

/**
 * Created by SCIP on 20.09.2016.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User getForm(){
        return new User();
    }

    @InitBinder("user")
    protected void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(new UserValidator(userService));
    }

    @RequestMapping("/registration")
    public String register(){
        return "registration";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String save(@ModelAttribute("user") @Valid User user,
                       BindingResult bindingResult){
        userService.save(user);
        return "redirect:/login";
    }
}
