package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proj.form.UsersOrdersForm;
import proj.service.UserOrderService;
import proj.service.implementation.validator.UsersOrdersFormSaveValidator;

import javax.validation.Valid;


/**
 * Created by SC on 18.03.2017.
 */
@Controller
public class UserOrderSaveController {

    @Autowired
    private UserOrderService userOrderService;

    @InitBinder("userOrdersForm")
    protected void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(new UsersOrdersFormSaveValidator());
    }

    @RequestMapping(value = "/admin/manager/createOrder", method = RequestMethod.POST, params = "createOrder")
    public String saveUserOrderFromForm(@ModelAttribute(value = "userOrdersForm") @Valid UsersOrdersForm usersOrdersForm,
                                        BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "createOrder";
        }
        userOrderService.save(usersOrdersForm);
        return "redirect: /admin/manager/orderList";
    }
}
