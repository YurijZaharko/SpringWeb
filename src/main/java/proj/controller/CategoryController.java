package proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SCIP on 16.08.2016.
 */
@Controller
public class CategoryController {

    @RequestMapping("/category/product")
    public String showProduct(){ return "product";}
}
