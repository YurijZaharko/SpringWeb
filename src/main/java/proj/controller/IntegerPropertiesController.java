package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
