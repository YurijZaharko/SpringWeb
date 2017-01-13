package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proj.entity.User;
import proj.form.Filter.UserFilterForm;
import proj.service.UserService;
import proj.service.implementation.MailSender;
import proj.service.implementation.validator.UserValidator;

import javax.validation.Valid;


/**
 * Created by SCIP on 20.09.2016.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MailSender mailSender;

    @ModelAttribute("user")
    public User getForm(){
        return new User();
    }

    @ModelAttribute("filter")
    public UserFilterForm userFilterForm(){return new UserFilterForm();}

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
        if (bindingResult.hasErrors()){
            return "registration";
        }
        userService.save(user);
        mailSender.sendMail("Registration mail", user.getLogin(), "Registration success! Thank you for registering");
        return "redirect:/login";
    }

    @RequestMapping("/admin/users")
    public String showUsers(Model model,
                            @PageableDefault(20)Pageable pageable,
                            @ModelAttribute("filter") UserFilterForm userFilterForm){
        model.addAttribute("allUsers", userService.findAll(pageable, userFilterForm));
        return "users";
    }
}
