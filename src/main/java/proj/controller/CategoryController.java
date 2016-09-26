package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proj.entity.Category;

import proj.entity.StringProperties;
import proj.service.CategoryService;
import proj.service.StringPropertiesService;

import java.util.List;

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

    @RequestMapping("/admin/adminCategory/categoryWithProperty/")
    public String showCategoryWithStringProperty(Model model){
        model.addAttribute("categoriesWithProperty", categoryService.findAllWithProperty());
        model.addAttribute("stringPropertiesList", stringPropertiesService.findAll());
        return "categoryWithProperty";
    }

    public String showCategoryWithIntegerProperty(){

    }

    @RequestMapping(value = "/admin/adminCategory/categoryWithProperty", method = RequestMethod.POST)
    public String saveCategoryWithProperty(@ModelAttribute("category") Category category){
        List<StringProperties> stringPropertiesList = category.getStringPropertiesList();
        System.out.println(stringPropertiesList);
        return "redirect:/admin/adminCategory/categoryWithProperty";
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
