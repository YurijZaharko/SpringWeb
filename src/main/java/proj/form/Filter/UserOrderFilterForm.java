package proj.form.Filter;

import proj.entity.OrderDelivery;

import java.util.regex.Pattern;

/**
 * Created by SC on 11.02.2017.
 */
public class UserOrderFilterForm {

    private String orderIdString = "";

    private int orderId = 0;

    private String phoneNumber = "";

    private OrderDelivery orderDelivery;

    private String productIdString = "";

    private int productId = 0;

    private static final Pattern pattern = Pattern.compile("^[0-9]{1,9}$");

    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\(\\d{3}\\)\\d{3}-\\d{4}$");

    public String getOrderIdString() {
        return orderIdString;
    }

    public void setOrderIdString(String orderIdString) {
        if(pattern.matcher(orderIdString).matches()){
            setOrderId(Integer.valueOf(orderIdString));
        }
        this.orderIdString = orderIdString;
    }

    public int getOrderId() {
        return orderId;
    }

    private void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(PHONE_PATTERN.matcher(phoneNumber).matches()) {
            this.phoneNumber = phoneNumber;
        }
    }

    public String getProductIdString() {
        return productIdString;
    }

    public void setProductIdString(String productIdString) {
        if(pattern.matcher(productIdString).matches()){
            setProductId(Integer.valueOf(productIdString));
        }
        this.productIdString = productIdString;
    }

    public int getProductId() {
        return productId;
    }

    private void setProductId(int productId) {
        this.productId = productId;
    }

    public OrderDelivery getOrderDelivery() {
        return orderDelivery;
    }

    public void setOrderDelivery(OrderDelivery orderDelivery) {
        this.orderDelivery = orderDelivery;
    }

}
