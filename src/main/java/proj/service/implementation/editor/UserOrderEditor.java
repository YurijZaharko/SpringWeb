package proj.service.implementation.editor;

import proj.entity.UserOrder;
import proj.service.UserOrderService;

import java.beans.PropertyEditorSupport;

/**
 * Created by SC on 19.02.2017.
 */
public class UserOrderEditor extends PropertyEditorSupport{

    private final UserOrderService userOrderService;

    public UserOrderEditor(UserOrderService userOrderService) {
        this.userOrderService = userOrderService;
    }
    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        UserOrder userOrder = userOrderService.findById(Integer.valueOf(text));
        setValue(userOrder);
    }
}
