package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import proj.form.Filter.ProductFrontFilterForm;
import proj.service.*;


/**
 * Created by SCIP on 15.08.2016.
 */
@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StringPropertiesService stringPropertiesService;

    @ModelAttribute("productFrontFilterForm")
    private ProductFrontFilterForm getProductFrontFilterForm(){return new ProductFrontFilterForm();}

    @RequestMapping("/admin")
    public String showAdmin(){return "admin";}

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/")
    public String showIndex(Model model){
        model.addAttribute("categories", categoryService.findByRootCategoryTrueFetchChild());
        return  "index";
    }

    @RequestMapping("/category/{id}")
    public String showProductInCategory(Model model,
                                        @PathVariable("id") int id,
                                        @PageableDefault(20) Pageable pageable,
                                        @ModelAttribute(value = "productFrontFilterForm") ProductFrontFilterForm productFrontFilterForm){
        model.addAttribute("products", productService.findProductByCategoryId(pageable, productFrontFilterForm, id));
        model.addAttribute("categories", categoryService.findByRootCategoryTrueFetchChild());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("propertyMap", stringPropertiesService.findPropertyAndValueByCategoryId(id));
        System.out.println();
        return "indexProduct";
    }

}
