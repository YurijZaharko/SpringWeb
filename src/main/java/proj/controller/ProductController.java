package proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import proj.entity.Product;

/**
 * Created by SCIP on 16.08.2016.
 */
@Controller
public class ProductController {
    @RequestMapping("/admin/adminCreateProduct")
    public String showCreateProduct(){
        return "adminCreateProduct";
    }
}
