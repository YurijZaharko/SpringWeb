package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import proj.controller.staticMethod.CommonMethod;
import proj.entity.StringProperties;
import proj.entity.ValueOfStringProperties;
import proj.form.Filter.StringPropertiesFilterForm;
import proj.service.StringPropertiesService;
import proj.service.ValueOfStringPropertiesService;
import proj.service.implementation.editor.ValueOfStringPropertiesEditor;

/**
 * Created by SC on 04.09.2016.
 */
@Controller
public class StringPropertiesController {
    @Autowired
    private StringPropertiesService stringPropertiesService;

    @Autowired
    private ValueOfStringPropertiesService valueOfStringPropertiesService;

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

    @ModelAttribute("filter")
    public StringPropertiesFilterForm stringPropertiesFilterForm(){return new StringPropertiesFilterForm();}

    @RequestMapping("/admin/adminStringProperties")
    public String showProperties(Model model,
                                 @PageableDefault(5)Pageable pageable,
                                 @ModelAttribute("filter") StringPropertiesFilterForm stringPropertiesFilterForm){
        model.addAttribute("stringProperties", stringPropertiesService.findAll(pageable, stringPropertiesFilterForm));
        return "adminStringProperties";
    }

    @RequestMapping(value = "/admin/adminStringProperties", method = RequestMethod.POST)
    public String save(@ModelAttribute("stringProperty") StringProperties stringProperties,
                       @PageableDefault(5)Pageable pageable,
                       @ModelAttribute("filter") StringPropertiesFilterForm stringPropertiesFilterForm){
        stringPropertiesService.save(stringProperties);
        return "redirect:/admin/adminStringProperties" + CommonMethod.getParams(pageable, stringPropertiesFilterForm);
    }

    @RequestMapping("/admin/adminProperties/deleteStringProperty/{id}")
    public String deleteStringProperty(@PathVariable("id") int id,
                                       @PageableDefault(5)Pageable pageable,
                                       @ModelAttribute("filter") StringPropertiesFilterForm stringPropertiesFilterForm){
        stringPropertiesService.deleteById(id);
        return "redirect:/admin/adminStringProperties" + CommonMethod.getParams(pageable, stringPropertiesFilterForm);
    }

    @RequestMapping("/admin/adminProperties/updateStringProperty/{id}")
    public String updateStringProperty(@PathVariable("id") int id, Model model,
                                       @PageableDefault(5)Pageable pageable,
                                       @ModelAttribute("filter") StringPropertiesFilterForm stringPropertiesFilterForm){
        model.addAttribute("stringProperty", stringPropertiesService.findById(id));
        model.addAttribute("stringProperties", stringPropertiesService.findAll(pageable, stringPropertiesFilterForm));
        return "adminStringProperties";
    }



}
