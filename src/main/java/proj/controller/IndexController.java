package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import proj.entity.StringProperties;
import proj.service.CategoryService;

/**
 * Created by SCIP on 15.08.2016.
 */
@Controller
public class IndexController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/")
    public String showIndex(){return  "index";}

    @RequestMapping("/admin")
    public String showAdmin(){return "admin";}

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

}
