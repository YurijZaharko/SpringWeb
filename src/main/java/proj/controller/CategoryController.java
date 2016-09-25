package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proj.entity.Category;
import proj.entity.StringProperties;
import proj.service.CategoryService;
import proj.service.StringPropertiesService;

/**
 * Created by SCIP on 16.08.2016.
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    StringPropertiesService stringPropertiesService;

    @ModelAttribute("category")
    public Category getCategory(){
        return new Category();
    }

    @RequestMapping("/admin/adminCategory")
    public String showCategory(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "adminCategory";
    }

    @RequestMapping("/admin/adminCategory/categoryWithProperty/{id}")
    public String showCategoryWithProperty(Model model, @PathVariable int id){
        model.addAttribute("categoriesWithProperty", categoryService.findAllWithProperty(id));
        model.addAttribute("stringPropertiesList", stringPropertiesService.findAll());
        return "categoryWithProperty";
    }

    @RequestMapping(value = "/admin/adminCategory", method = RequestMethod.POST)
    public String save(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/admin/adminCategory";
    }

    @Modifying
    @Transactional
    @RequestMapping("/admin/adminCategory/delete/{id}")
    public String deleteBrand(@PathVariable int id){
        categoryService.deleteById(id);
        return "redirect:/admin/adminCategory";
    }

    @RequestMapping("/admin/adminCategory/update/{id}")
    public String updateCategory(@PathVariable int id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "adminCategory";
    }


}
