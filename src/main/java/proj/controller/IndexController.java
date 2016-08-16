package proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import proj.entity.StringProperties;

/**
 * Created by SCIP on 15.08.2016.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String showIndex(){return  "index";}

    @RequestMapping("/admin")
    public String showAdmin(){return "/admin";}

    @RequestMapping("/payment")
    public String showPayment(){
        return "/payment";
    }

    @RequestMapping("/registration")
    public String showRegistration(){return "/registration";}

    @RequestMapping("/contact")
    public String showContact(){return "/contact";}

    @RequestMapping("/category")
    public String showCategory(){return "/category";}
}
