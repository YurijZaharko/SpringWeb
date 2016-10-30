package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import proj.entity.StringProperties;
import proj.entity.ValueOfStringProperties;
import proj.form.PropertyAndValueStringsForm;
import proj.service.StringPropertiesService;
import proj.service.ValueOfStringPropertiesService;
import proj.service.implementation.editor.ValueOfStringPropertiesEditor;

/**
 * Created by SC on 04.09.2016.
 */
@Controller
public class StringPropertiesController {
    @Autowired
    StringPropertiesService stringPropertiesService;

    @Autowired
    ValueOfStringPropertiesService valueOfStringPropertiesService;

    @InitBinder("valueOfStringProperties")
    protected void inBinder(WebDataBinder webDataBinder){
       webDataBinder.registerCustomEditor(ValueOfStringProperties.class, new ValueOfStringPropertiesEditor(valueOfStringPropertiesService));
    }



    @ModelAttribute("stringProperty")
    public StringProperties getStringProperties(){
        return new StringProperties();
    }

    @ModelAttribute("valueOfStringProperty")
    public ValueOfStringProperties getValueOfStringProperties(){return new ValueOfStringProperties();}

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
