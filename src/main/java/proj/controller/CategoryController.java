package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import proj.entity.Category;

import proj.entity.StringProperties;
import proj.service.CategoryService;
import proj.service.IntegerPropertiesService;
import proj.service.StringPropertiesService;
import proj.service.implementation.editor.CategoryEditor;
import proj.service.implementation.editor.StrPropEditor;

/**
 * Created by SCIP on 16.08.2016.
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    StringPropertiesService stringPropertiesService;

    IntegerPropertiesService integerPropertiesService;

    @ModelAttribute("category")
    public Category getCategory(){
        return new Category();
    }

    @InitBinder("category")
    protected void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
        webDataBinder.registerCustomEditor(StringProperties.class, new StrPropEditor(stringPropertiesService));
    }

    @RequestMapping("/admin/adminCategory")
    public String showCategory(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "adminCategory";
    }

    @RequestMapping("/admin/adminCategory/categoryWithProperty/{id}")
    public String showCategoryWithStringProperty(Model model, @PathVariable int id){
        model.addAttribute("category", categoryService.findByIdWithAllFetch(id));
//        model.addAllAttributes("categoryChild" , categoryService.findByIdWithCategoryChild(id));
        model.addAttribute("stringProperties", stringPropertiesService.findAll());
        return "categoryWithProperty";
    }

    public String showCategoryWithIntegerProperty(){
        return null;
    }

    @Transactional
    @RequestMapping(value = "/admin/adminCategory/categoryWithProperty", method = RequestMethod.POST)
    public String saveCategoryWithProperty(@ModelAttribute("category") Category category){
        Category temp = categoryService.findById(Integer.valueOf(category.getName()));
//        temp.getStringPropertiesList().addAll(category.getStringPropertiesList());
//        for (StringProperties stringProperty : category.getStringPropertiesList()) {
//            temp.getStringPropertiesList().add(stringPropertiesService.findById(stringProperty.getId()));
//        }
        categoryService.save(temp);

        return "redirect:/admin/adminCategory/categoryWithProperty/" + category.getId();
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
