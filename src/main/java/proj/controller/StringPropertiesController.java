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
public class StringPropertiesController {
    @Autowired
    StringPropertiesService stringPropertiesService;
    @Autowired
    IntegerPropertiesService integerPropertiesService;

    @ModelAttribute("stringProperty")
    public StringProperties getStringProperties(){
        return new StringProperties();
    }

    @RequestMapping("/admin/adminStringProperties")
    public String showProperties(Model model){
        model.addAttribute("stringProperties", stringPropertiesService.findAll());
        return "adminStringProperties";
    }

    @RequestMapping(value = "/admin/adminStringProperties", method = RequestMethod.POST)
    public String save(@ModelAttribute("stringProperty") StringProperties stringProperties){
        stringPropertiesService.save(stringProperties);
        return "redirect:/admin/adminStringProperties";
    }

    @RequestMapping("/admin/adminProperties/deleteStringProperty/{id}")
    public String deleteStringProperty(@PathVariable("id") int id){
        stringPropertiesService.deleteById(id);
        return "redirect:/admin/adminProperties";
    }



    @RequestMapping("/admin/adminStringProperties/updateStringProperty/{id}")
    public String updateStringProperty(@PathVariable("id") int id, Model model){
        model.addAttribute("stringProperty", stringPropertiesService.findById(id));
        return "redirect:/admin/adminStringProperties";
    }

}
