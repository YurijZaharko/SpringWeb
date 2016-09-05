package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proj.entity.Country;
import proj.service.CountryService;

/**
 * Created by SCIP on 27.08.2016.
 */
@Controller
public class CountryController {
    @Autowired
    CountryService countryService;

    @RequestMapping("/admin/adminCountry")
    public String showCountry(Model model){
        model.addAttribute("Country", countryService.findAll());
        return "adminCountry";
    }

    @RequestMapping(value = "/admin/adminCountry", method = RequestMethod.POST)
    public String save(@ModelAttribute("country") Country country){
        countryService.save(country);
        return "redirect:/admin/adminCountry";
    }

    @Modifying
    @Transactional
    @RequestMapping("/admin/adminCountry/delete/{id}")
    public String delete(@PathVariable int id){
        countryService.deleteById(id);
        return "redirect:/admin/adminCountry";
    }

    @ModelAttribute("country")
    public Country getCountry(){
        return new Country();
    }

    @RequestMapping("/admin/adminCountry/update/{id}")
    public String updateCountry(@PathVariable int id, Model model){
        model.addAttribute("country",  countryService.findById(id));
        return "adminCountry";
    }

}
