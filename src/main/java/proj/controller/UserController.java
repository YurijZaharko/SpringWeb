package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proj.entity.User;
import proj.service.UserService;

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

    @RequestMapping("/registration")
    public String register(){
        return "registration";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String save(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/login";
    }
}
