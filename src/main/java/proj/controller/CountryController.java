package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import proj.controller.staticMethod.CommonMethod;
import proj.entity.Country;
import proj.form.CountryFilterForm;
import proj.service.CountryService;
import proj.service.implementation.validator.CountryValidator;

import javax.validation.Valid;

/**
 * Created by SCIP on 27.08.2016.
 */
@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;

    @ModelAttribute("country")
    public Country getForm(){
        return new Country();
    }

    @ModelAttribute("filter")
    public CountryFilterForm CountryFilterForm(){
        return new CountryFilterForm();
    }

    @InitBinder("country")
    protected void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(new CountryValidator(countryService));
    }

    @RequestMapping("/admin/adminCountry")
    public String showCountry(Model model,
                              @PageableDefault(5) Pageable pageable,
                              @ModelAttribute(value = "filter") CountryFilterForm countryFilterForm){
        model.addAttribute("page", countryService.findAll(pageable, countryFilterForm));
        return "adminCountry";
    }

    @RequestMapping("/admin/adminCountry/delete/{id}")
    public String delete(@PathVariable int id,
                         @PageableDefault(5) Pageable pageable,
                         @ModelAttribute(value = "filter") CountryFilterForm countryFilterForm){
        countryService.deleteById(id);
        return "redirect:/admin/adminCountry" + CommonMethod.getParams(pageable, countryFilterForm);
    }

    @RequestMapping("/admin/adminCountry/update/{id}")
    public String updateCountry(@PathVariable int id, Model model,
                                @PageableDefault(5) Pageable pageable,
                                @ModelAttribute(value = "filter") CountryFilterForm countryFilterForm){
        model.addAttribute("country",  countryService.findById(id));
        model.addAttribute("page", countryService.findAll(pageable, countryFilterForm));
        return "adminCountry";
    }

    @RequestMapping(value = "/admin/adminCountry", method = RequestMethod.POST)
    public String save(@ModelAttribute("country") @Valid Country country,
                       BindingResult bindingResult,
                       @PageableDefault(5) Pageable pageable,
                       @ModelAttribute(value = "filter") CountryFilterForm countryFilterForm,
                       Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("page", countryService.findAll(pageable, countryFilterForm));
            return "adminCountry";
        }
        countryService.save(country);
        return "redirect:/admin/adminCountry" + CommonMethod.getParams(pageable, countryFilterForm);
    }





}
