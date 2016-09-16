package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import proj.entity.Brand;
import proj.form.BrandFilterForm;
import proj.service.BrandService;
import proj.service.implementation.editor.BrandEditor;
import proj.service.implementation.validator.BrandValidator;

import javax.validation.Valid;

/**
 * Created by SCIP on 25.08.2016.
 */
@Controller
public class BrandController {
    @Autowired
    BrandService brandService;

    @InitBinder("brand")
    protected void initBinder(WebDataBinder webDataBinder){
//        webDataBinder.registerCustomEditor(Brand.class, new BrandEditor(brandService));
        webDataBinder.setValidator(new BrandValidator(brandService));
    }

    @ModelAttribute("brand")
    public Brand getBrand(){
        return new Brand();
    }

    @ModelAttribute("brandFilterForm")
    public BrandFilterForm getBrandFilterForm(){
        return new BrandFilterForm();
    }

    @RequestMapping("/admin/adminBrand")
    public String showBrand(Model model,
                            @PageableDefault(5) Pageable pageable,
                            @ModelAttribute(value = "brandFilterForm") BrandFilterForm brandFilterForm){
        model.addAttribute("page", brandService.findAll(pageable, brandFilterForm));
        return "adminBrand";
    }

    @RequestMapping(value = "/admin/adminBrand", method = RequestMethod.POST)
    public String save(@ModelAttribute("brand") @Valid Brand brand, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("Brands", brandService.findAll());
            return "adminBrand";
        }
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
