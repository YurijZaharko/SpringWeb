package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import proj.entity.Brand;
import proj.entity.Category;
import proj.entity.Country;
import proj.entity.Product;
import proj.form.ProductForm;
import proj.service.BrandService;
import proj.service.CategoryService;
import proj.service.CountryService;
import proj.service.ProductService;
import proj.service.implementation.editor.ProductEditor;

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

    @InitBinder("productForm")
    protected void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Product.class, new ProductEditor(productService));
    }

    @ModelAttribute("productForm")
    public ProductForm getProductForm(){
        return new ProductForm();
    }

    @RequestMapping("/admin/adminProduct")
    public String showProduct(Model model){
        model.addAttribute("Products", productService.findAll());
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
    public  String save(@ModelAttribute("productForm") ProductForm productForm){
        productService.save(productForm);
        return "redirect:/admin/adminProduct";
    }

    @RequestMapping("/admin/adminProduct/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("productForm", productService.findForForm(id));
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "adminProduct";
    }

    @Modifying
    @Transactional
    @RequestMapping("/admin/adminProduct/delete/{id}")
    public String delete(@PathVariable("id") int id){
        productService.delete(id);
        return "redirect:/admin/adminProduct";
    }
}
