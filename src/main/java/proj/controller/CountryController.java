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
import org.springframework.web.bind.annotation.*;
import proj.entity.Country;
import proj.form.CountryFilterForm;
import proj.service.CountryService;

/**
 * Created by SCIP on 27.08.2016.
 */
@Controller
public class CountryController {
    @Autowired
    CountryService countryService;

    @ModelAttribute("country")
    public Country getCountry(){
        return new Country();
    }

    @ModelAttribute("filter")
    public CountryFilterForm getCountryFilterForm(){
        return new CountryFilterForm();
    }

    @RequestMapping("/admin/adminCountry")
    public String showCountry(Model model,
                              @PageableDefault(5) Pageable pageable,
                              @ModelAttribute(value = "filter") CountryFilterForm countryFilterForm){
        model.addAttribute("page", countryService.findAll(pageable, countryFilterForm));
        return "adminCountry";
    }

    @Modifying
    @Transactional
    @RequestMapping("/admin/adminCountry/delete/{id}")
    public String delete(@PathVariable int id,
                         @PageableDefault(5) Pageable pageable,
                         @ModelAttribute(value = "filter") CountryFilterForm countryFilterForm){
        countryService.deleteById(id);
        return "redirect:/admin/adminCountry" + getParams(pageable, countryFilterForm);
    }

    @RequestMapping(value = "/admin/adminCountry", method = RequestMethod.POST)
    public String save(@ModelAttribute("country") Country country){
        countryService.save(country);
        return "redirect:/admin/adminCountry";
    }

    @RequestMapping("/admin/adminCountry/update/{id}")
    public String updateCountry(@PathVariable int id, Model model){
        model.addAttribute("country",  countryService.findById(id));
        return "adminCountry";
    }

    private String getParams(Pageable pageable, CountryFilterForm form){
        StringBuilder buffer = new StringBuilder();
        buffer.append("?page=");
        buffer.append(String.valueOf(pageable.getPageNumber()+1));
        buffer.append("&size=");
        buffer.append(String.valueOf(pageable.getPageSize()));
        if(pageable.getSort()!=null){
            buffer.append("&sort=");
            Sort sort = pageable.getSort();
            sort.forEach((order)->{
                buffer.append(order.getProperty());
                if(order.getDirection()!=Direction.ASC)
                    buffer.append(",desc");
            });
        }
        buffer.append("&search=");
        buffer.append(form.getSearch());
        return buffer.toString();
    }

}
