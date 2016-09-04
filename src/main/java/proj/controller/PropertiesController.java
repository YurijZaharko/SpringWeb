package proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SC on 04.09.2016.
 */
@Controller
public class PropertiesController {

    @RequestMapping("/admin/adminProperties")
    public String showProperties(){
        return "adminProperties";
    }
}
