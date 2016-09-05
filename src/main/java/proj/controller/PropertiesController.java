package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import proj.entity.IntegerProperties;
import proj.entity.StringProperties;
import proj.service.IntegerPropertiesService;
import proj.service.StringPropertiesService;
import proj.service.implementation.editor.StringPropertiesEditor;

/**
 * Created by SC on 04.09.2016.
 */
@Controller
public class PropertiesController {
    @Autowired
    StringPropertiesService stringPropertiesService;
    @Autowired
    IntegerPropertiesService integerPropertiesService;

    @ModelAttribute("stringProperties")
    public StringProperties getStringProperties(){
        return new StringProperties();
    }

    @ModelAttribute("integerProperties")
    public IntegerProperties getIntegerProperties(){
        return new IntegerProperties();
    }

    @RequestMapping("/admin/adminProperties")
    public String showProperties(Model model){
        model.addAttribute("stringProperties", stringPropertiesService.findAll());
        model.addAttribute("integerProperties", integerPropertiesService.findAll());
        return "adminProperties";
    }

    @RequestMapping(value = "/admin/adminProperties", method = RequestMethod.POST)
    public String save(@ModelAttribute("stringProperty") StringProperties stringProperties){
        stringPropertiesService.save(stringProperties);
        return "redirect:/admin/adminProperties";
    }

    @RequestMapping("/admin/adminProperties/deleteStringProperty/{id}")
    public String deleteStringProperty(@PathVariable("id") int id){
        stringPropertiesService.deleteById(id);
        return "redirect:/admin/adminProperties";
    }

    @RequestMapping("/admin/adminProperties/deleteIntegerProperty/{id}")
    public String deleteIntegerProperty(@PathVariable("id") int id){
        integerPropertiesService.deleteById(id);
        return "redirect:/admin/adminProperties";
    }
    @RequestMapping("/admin/adminProperties/updateStringProperty/{id}")
    public String updateStringProperty(@PathVariable("id") int id, Model model){
        model.addAttribute("stringProperty", stringPropertiesService.findById(id));
        return "redirect:/admin/adminProperties";
    }
    @RequestMapping("/admin/adminProperties/updateIntegerProperty/{id}")
    public String updateIntegerProperty(@PathVariable("id") int id, Model model){
        model.addAttribute("integerProperty", integerPropertiesService.findById(id));
        return "redirect:/admin/adminProperties";
    }
}
