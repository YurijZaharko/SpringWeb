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
import proj.entity.Category;
import proj.entity.Country;
import proj.entity.Product;
import proj.form.Filter.ProductFilterForm;
import proj.form.ProductForm;
import proj.service.BrandService;
import proj.service.CategoryService;
import proj.service.CountryService;
import proj.service.ProductService;
import proj.service.implementation.editor.BrandEditor;
import proj.service.implementation.editor.CategoryEditor;
import proj.service.implementation.editor.CountryEditor;
import proj.service.implementation.editor.ProductEditor;
import proj.service.implementation.validator.ProductFormValidator;

import javax.validation.Valid;

/**
 * Created by SCIP on 16.08.2016.
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    BrandService brandService;
    @Autowired
    CountryService countryService;
    @Autowired
    CategoryService categoryService;

    @ModelAttribute("productForm")
    public ProductForm getProductForm(){
        return new ProductForm();
    }

    @ModelAttribute("productFilterForm")
    public ProductFilterForm getProductFilterForm(){return new ProductFilterForm();}

    @InitBinder("productForm")
    protected void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Brand.class, new BrandEditor(brandService));
        webDataBinder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
        webDataBinder.registerCustomEditor(Country.class, new CountryEditor(countryService));
        webDataBinder.setValidator(new ProductFormValidator(productService));
    }

    @RequestMapping("/admin/adminProduct")
    public String showProduct(Model model,
                              @PageableDefault(5) Pageable pageable,
                              @ModelAttribute(value = "productFilterForm") ProductFilterForm productFilterForm){
        model.addAttribute("Products", productService.findAll(pageable, productFilterForm));
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "adminProduct";
    }


//    @RequestMapping(value = "/admin/adminProduct", method = RequestMethod.POST)
//    public String save(@RequestParam("price") int price,
//                       @RequestParam("name") String productName,
//                       @RequestParam("partNumber") String partNumber,
//                       @RequestParam("brandId") int brandId,
//                       @RequestParam("countryId") int countryId,
//                       @RequestParam("categoryId") int categoryId){
//        productService.save(price, productName, partNumber, brandId, countryId, categoryId);
//
//        return "redirect:/admin/adminProduct";
//    }

    @RequestMapping(value = "/admin/adminProduct", method = RequestMethod.POST)
    public String save(@ModelAttribute("productForm") @Valid ProductForm productForm, BindingResult bindingResult,
                        Model model){
        if(bindingResult.hasErrors()){
            add(model);
            return "adminProduct";
        }
        productService.save(productForm);
        return "redirect:/admin/adminProduct";
    }


    @RequestMapping("/admin/adminProduct/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("productForm", productService.findForForm(id));
        add(model);
        return "adminProduct";
    }

    @Modifying
    @Transactional
    @RequestMapping("/admin/adminProduct/delete/{id}")
    public String delete(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/admin/adminProduct";
    }

    private void add(Model model){
        model.addAttribute("Products", productService.findAll());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("categories", categoryService.findAll());
    }
}
