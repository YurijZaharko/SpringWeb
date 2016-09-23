package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import proj.service.CategoryService;
import proj.service.ListOfPropertyAndValueStringService;

/**
 * Created by SCIP on 11.09.2016.
 */
@Controller
public class CategoryAddStringPropertiesController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/admin/adminCategory/categoryAddStringProperties")
    public String showCategoryAddStringProperties(Model model){
        model.addAttribute("categoryAddStringProperties", );
        return "categoryAddStringProperties";
    }
}
