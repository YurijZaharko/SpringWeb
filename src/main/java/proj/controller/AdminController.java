package proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SCIP on 21.08.2016.
 */
@Controller
public class AdminController {
    @RequestMapping("/admin/adminCreateProduct")
    public String showAdminCreateProduct(){return "adminCreateProduct";}
}
