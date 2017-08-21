package proj.form;

import proj.entity.OrderDelivery;
import proj.entity.OrderStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SC on 09.02.2017.
 */
public class UsersOrdersForm {

    private String orderId;

    private String name;

    private String surname;

    private String phoneNumber;

    private OrderDelivery orderDelivery;

    private OrderStatus orderStatus;

    private String newProductId;

    private String quantity = "1";

    private List<OrderFieldForm> orderFields = new ArrayList<>();

    public UsersOrdersForm() {
        this.orderStatus = OrderStatus.NEW_ORDER;
    }

    public OrderDelivery getOrderDelivery() {
        return orderDelivery;
    }

    public void setOrderDelivery(OrderDelivery orderDelivery) {
        this.orderDelivery = orderDelivery;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderFieldForm> getOrderFields() {
        return orderFields;
    }

    public void setOrderFields(List<OrderFieldForm> orderFields) {
        this.orderFields = orderFields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNewProductId() {
        return newProductId;
    }

    public void setNewProductId(String newProductId) {
        this.newProductId = newProductId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
