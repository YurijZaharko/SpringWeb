package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import proj.entity.User;
import proj.service.UserService;

/**
 * Created by SCIP on 20.09.2016.
 */
@ControllerAdvice
public class GlobalController {
    @Autowired
    private UserService userService;

    @ModelAttribute("authUser")
    public User getUser(){
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        if(!"anonymousUser".equals(id)){
            return userService.findById(Integer.valueOf(id));
        }
        return null;
    }
}
