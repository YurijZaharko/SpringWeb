package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import proj.service.CategoryService;

/**
 * Created by SCIP on 16.08.2016.
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/admin/adminCategory")
    public String showCategory(Model model){
        model.addAttribute("Categories", categoryService.findAll());
        return "adminCategory";
    }

    @Modifying
    @Transactional
    @RequestMapping("/admin/adminCategory/delete/{id}")
    public String deleteBrand(@PathVariable int id){
        categoryService.deleteById(id);
        return "redirect:/admin/adminCategory";
    }

    @RequestMapping(value = "/admin/adminCategory", method = RequestMethod.POST)
    public String save(@RequestParam("name") String name){
        categoryService.save(name);
        return "redirect:/admin/adminCategory";
    }


}
