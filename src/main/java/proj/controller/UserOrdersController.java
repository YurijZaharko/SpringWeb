package proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import proj.form.Filter.UserOrderFilterForm;
import proj.form.UsersOrdersForm;
import proj.service.UserOrderService;
import proj.service.implementation.validator.UsersOrdersFormValidator;

import javax.validation.Valid;

/**
 * Created by SC on 09.02.2017.
 */
@Controller
public class UserOrdersController {

    @Autowired
    private UserOrderService userOrderService;

    @ModelAttribute("userOrdersForm")
    public UsersOrdersForm getUserOrdersForm(){return new UsersOrdersForm();}

    @ModelAttribute("userOrderFilterForm")
    public UserOrderFilterForm getUserOrderFilterForm(){return new UserOrderFilterForm();}

    @InitBinder("userOrdersForm")
    protected void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(new UsersOrdersFormValidator());
    }

    @RequestMapping("/admin/manager/orderList")
    public String showUserOrders(Model model,
                                 @PageableDefault() Pageable pageable,
                                 @ModelAttribute(value = "userOrderFilterForm") UserOrderFilterForm userOrderFilterForm){
        model.addAttribute("userOrders", userOrderService.findAll(pageable, userOrderFilterForm));
//        model.addAttribute("userOrders", userOrderService.findAllFetch(pageable, userOrderFilterForm));
        return "orderList";
    }

    @RequestMapping(value = "/admin/manager/createOrder")
    public String createOrder(Model model){
        model.addAttribute("userOrdersForm", userOrderService.createNewOrder());
        return "createOrder";
    }

    @RequestMapping(value = "/admin/manager/createOrder", method = RequestMethod.POST, params = "addProduct")
    public String addProductToOrder(Model model,
                              @ModelAttribute(value = "userOrdersForm")@Valid UsersOrdersForm usersOrdersForm,
                                    BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "createOrder";
        }
        model.addAttribute("userOrdersForm", userOrderService.addProduct(usersOrdersForm));
        return "createOrder";
    }

    @RequestMapping("/admin/manager/createOrder/update/{id}")
    public String updateOrder(@PathVariable("id") int id,
                              @ModelAttribute(value = "userOrdersForm") UsersOrdersForm usersOrdersForm,
                              Model model) {
        model.addAttribute("userOrdersForm", userOrderService.findUserOrdersFormById(id));
        return "createOrder";
    }

}
