package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proj.entity.Brand;
import proj.service.BrandService;

/**
 * Created by SCIP on 25.08.2016.
 */
@Controller
public class BrandController {
    @Autowired
    BrandService brandService;

    @ModelAttribute("brand")
    public Brand getBrand(){
        return new Brand();
    }

    @RequestMapping("/admin/adminBrand")
    public String showBrand(Model model){
        model.addAttribute("Brands", brandService.findAll());
        return "adminBrand";
    }

    @RequestMapping(value = "/admin/adminBrand", method = RequestMethod.POST)
    public String save(@ModelAttribute("brand") Brand brand){
        brandService.save(brand);
        return "redirect:/admin/adminBrand";
    }

    @Modifying
    @Transactional
    @RequestMapping("/admin/adminBrand/delete/{id}")
    public String deleteBrand(@PathVariable int id){
        brandService.delete(id);
        return "redirect:/admin/adminBrand";
    }

    @RequestMapping("/admin/adminBrand/update/{id}")
    public String updateBrand(@PathVariable int id, Model model ){
        model.addAttribute("brand", brandService.findById(id));
        return "adminBrand";
    }
}
