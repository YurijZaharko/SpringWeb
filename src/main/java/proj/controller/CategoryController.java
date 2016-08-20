package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import proj.service.CategoryService;

/**
 * Created by SCIP on 16.08.2016.
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/category/product")
    public String showProduct(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "product";
    }


}
