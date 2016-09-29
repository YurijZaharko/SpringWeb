package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import proj.entity.IntegerProperties;
import proj.service.IntegerPropertiesService;

/**
 * Created by SC on 07.09.2016.
 */
@Controller

public class IntegerPropertiesController {
    @Autowired
    IntegerPropertiesService integerPropertiesService;

    @ModelAttribute("integerProperty")
    public IntegerProperties getIntegerProperties(){return new IntegerProperties();}


    @RequestMapping("/admin/adminIntegerProperties")
    public String showProperties(Model model){
        model.addAttribute("integerProperties", integerPropertiesService.findAll());
        return "adminIntegerProperties";
    }

    @RequestMapping(value = "/admin/adminIntegerProperties", method = RequestMethod.POST)
    public String save(@ModelAttribute("integerProperty") IntegerProperties integerProperties){
        integerPropertiesService.save(integerProperties);
        return "redirect:/admin/adminIntegerProperties";
    }

    @RequestMapping("/admin/adminIntegerProperties/delete/{id}")
    public String delete(@PathVariable("id") int id){
        integerPropertiesService.deleteById(id);
        return "redirect:/admin/adminIntegerProperties";
    }

    @RequestMapping("/admin/adminIntegerProperties/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("integerProperty" , integerPropertiesService.findById(id));
        return "redirect:/admin/adminIntegerProperties";
    }
}
