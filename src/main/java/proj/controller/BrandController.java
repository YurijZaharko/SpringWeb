package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import proj.service.BrandService;

/**
 * Created by SCIP on 25.08.2016.
 */
@Controller
public class BrandController {
    @Autowired
    BrandService brandService;

    @RequestMapping("/admin/adminBrand")
    public String showBrand(Model model){
        model.addAttribute("Brands", brandService.findAll());
        return "adminBrand";
    }
    @RequestMapping("/admin/adminBrand/delete/{id}")
    public String deleteBrand(@PathVariable int id){
        brandService.delete(id);
        return "redirect:/admin/adminBrand";
    }

    @RequestMapping(value = "/admin/adminBrand", method = RequestMethod.POST)
    public String save(@RequestParam("name") String name){
        brandService.save(name);
        return "redirect:/admin/adminBrand";
    }
}
