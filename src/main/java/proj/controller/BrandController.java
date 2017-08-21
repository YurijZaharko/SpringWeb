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
import proj.controller.staticMethod.CommonMethod;
import proj.entity.Brand;
import proj.form.Filter.BrandFilterForm;
import proj.service.BrandService;
import proj.service.implementation.validator.BrandValidator;

import javax.validation.Valid;

/**
 * Created by SCIP on 25.08.2016.
 */
@Controller
@RequestMapping("/admin")
public class BrandController {
    
    private final BrandService brandService;
    
    private static final String ADMIN_BRAND = "adminBrand";
    private static final String REDIRECT = "redirect:/admin/adminBrand";
    private static final String SEPERATOR = "/";
    
    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @InitBinder("brand")
    protected void initBinder(WebDataBinder webDataBinder){
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

    @RequestMapping(SEPERATOR + ADMIN_BRAND)
    public String showBrand(Model model,
                            @PageableDefault(5) Pageable pageable,
                            @ModelAttribute(value = "brandFilterForm") BrandFilterForm brandFilterForm){
        model.addAttribute("page", brandService.findAll(pageable, brandFilterForm));
        return ADMIN_BRAND;
    }

    @Modifying
    @Transactional
    @RequestMapping("/adminBrand/delete/{id}")
    public String deleteBrand(@PathVariable int id,
                              @PageableDefault(5) Pageable pageable,
                              @ModelAttribute(value = "brandFilterForm") BrandFilterForm brandFilterForm){
        brandService.delete(id);
        return REDIRECT  + CommonMethod.getParams(pageable, brandFilterForm);
    }

    @RequestMapping("/adminBrand/update/{id}")
    public String updateBrand(@PathVariable int id, Model model,
                              @PageableDefault(5) Pageable pageable,
                              @ModelAttribute(value = "brandFilterForm") BrandFilterForm brandFilterForm){
        model.addAttribute("brand", brandService.findById(id));
        model.addAttribute("page", brandService.findAll(pageable, brandFilterForm));
        return ADMIN_BRAND;
    }

    @RequestMapping(value = SEPERATOR + ADMIN_BRAND, method = RequestMethod.POST)
    public String save(@ModelAttribute("brand") @Valid Brand brand, BindingResult bindingResult, Model model,
                       @PageableDefault(5) Pageable pageable,
                       @ModelAttribute(value = "brandFilterForm") BrandFilterForm brandFilterForm){
        if (bindingResult.hasErrors()){
            model.addAttribute("page", brandService.findAll(pageable, brandFilterForm));
            return ADMIN_BRAND;
        }
        brandService.save(brand);
        return REDIRECT + CommonMethod.getParams(pageable, brandFilterForm);
    }
}
