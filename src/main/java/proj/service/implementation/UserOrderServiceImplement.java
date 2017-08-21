package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import proj.entity.OrderField;
import proj.entity.Product;
import proj.entity.User;
import proj.entity.UserOrder;
import proj.form.Filter.UserOrderFilterForm;
import proj.form.OrderFieldForm;
import proj.form.UsersOrdersForm;
import proj.repository.OrderFieldRepository;
import proj.repository.ProductRepository;
import proj.repository.UserOrderRepository;
import proj.repository.UserRepository;
import proj.service.UserOrderService;
import proj.service.implementation.specification.UserOrderFilterAdapter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SC on 07.02.2017.
 */
@Service
public class UserOrderServiceImplement implements UserOrderService {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private OrderFieldRepository orderFieldRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserOrder findById(int id) {
        return userOrderRepository.findOne(id);
    }

    @Override
    public Page<UserOrder> findAll(Pageable pageable, UserOrderFilterForm userOrderFilterForm) {
        userOrderRepository.deleteByUserOrderNULL();
        return userOrderRepository.findAll(new UserOrderFilterAdapter(userOrderFilterForm), pageable);
    }

    @Override
    public Page<UserOrder> findAllFetch(@PageableDefault(20) Pageable pageable, UserOrderFilterForm userOrderFilterForm) {

//        return userOrderRepository.findAllFetchOrderFields(pageable);
        return userOrderRepository.findAll(new UserOrderFilterAdapter(userOrderFilterForm), pageable);
    }

    @Override
    public UsersOrdersForm addProduct(UsersOrdersForm usersOrdersForm) {
        if (usersOrdersForm.getNewProductId() == null || Integer.valueOf(usersOrdersForm.getNewProductId()) == 0 ){
            return usersOrdersForm;
        }
        int productId = Integer.valueOf(usersOrdersForm.getNewProductId());
        Product product = productRepository.findById(productId);
        OrderFieldForm orderFieldForm = new OrderFieldForm();
        if (null != product ){
            orderFieldForm.setProductID(product.getId());
            orderFieldForm.setProductName(product.getProductName());
            orderFieldForm.setPartNumber(product.getPartNumber());
        }

        if (null != usersOrdersForm.getQuantity()) {
            orderFieldForm.setQuantityString(usersOrdersForm.getQuantity());
        }
        if (null != product.getPrice()) {
            orderFieldForm.setInPriceString(product.getPrice().toString());
        }else {
            orderFieldForm.setInPriceString("0");
        }
        if (null != product.getSellPrice()){
            orderFieldForm.setOutPriceString(product.getSellPrice().toString());
        }else {
            orderFieldForm.setOutPriceString("0");
        }
        usersOrdersForm.getOrderFields().add(orderFieldForm);
        usersOrdersForm.setNewProductId("0");
        return usersOrdersForm;
    }

    @Override
    public UsersOrdersForm createNewOrder() {
        UsersOrdersForm usersOrdersForm = new UsersOrdersForm();
        UserOrder userOrder = new UserOrder();
        userOrderRepository.save(userOrder);
        usersOrdersForm.setOrderId(Integer.toString(userOrder.getId()));

        return usersOrdersForm;
    }

    @Override
    public void save(UsersOrdersForm usersOrdersForm) {
        int orderId = Integer.valueOf(usersOrdersForm.getOrderId());
        UserOrder userOrder = userOrderRepository.findOne(orderId);
        User user = userRepository.findByPhoneNumber(usersOrdersForm.getPhoneNumber());
        if (user == null){
            user = new User();
            user.setPhoneNumber(usersOrdersForm.getPhoneNumber());
            user.createRegistrationDate();
        }
        user.setName(usersOrdersForm.getName());
        user.setSurname(usersOrdersForm.getSurname());

        List<OrderFieldForm> orderFieldFormList = usersOrdersForm.getOrderFields();

        List<OrderField> orderFieldList = new ArrayList<>();
        for (OrderFieldForm off : orderFieldFormList) {
            OrderField orderField = orderFieldRepository.findOne(off.getId());
            if (null == orderField){
                orderField = new OrderField();
                orderFieldList.add(orderField);
            }

                Product product = productRepository.findById(off.getProductID());
                orderField.setProduct(product);

                if(null != off.getQuantityString()){
                    int quantity = Integer.parseInt(off.getQuantityString());
                    if(quantity == 0){
                        quantity = 1;
                    }
                    orderField.setQuantity(quantity);
                } else {
                    orderField.setQuantity(1);
                }

                if (null != off.getInPriceString()){
                    BigDecimal price = new BigDecimal(off.getInPriceString());
                    if (price.equals(new BigDecimal(0))){
                        price = new BigDecimal(0.01);
                        orderField.setInPrice(price);
                    } else {
                        orderField.setInPrice(price);
                    }
                }

                if (null != off.getOutPriceString()){
                    BigDecimal price = new BigDecimal(off.getOutPriceString());
                    if (price.equals(new BigDecimal(0))){
                        orderField.setSellPrice(new BigDecimal(0.01));
                    } else {
                        orderField.setSellPrice(price);
                    }
                }

            orderField.setUserOrder(userOrder);
            orderFieldRepository.saveAndFlush(orderField);
        }
        userOrder.setOrderFields(orderFieldList);
        userRepository.save(user);
        userOrder.setUser(user);
        userOrder.setOrderDelivery(usersOrdersForm.getOrderDelivery());
        userOrder.setOrderStatus(usersOrdersForm.getOrderStatus());
        userOrderRepository.save(userOrder);
    }

    @Override
    public UsersOrdersForm findUserOrdersFormById(int id) {
        UsersOrdersForm usersOrdersForm = new UsersOrdersForm();
        UserOrder userOrder = userOrderRepository.findOneFetch(id);
        if (null != userOrder){
            usersOrdersForm.setOrderId(Integer.toString(userOrder.getId()));
            usersOrdersForm.setOrderDelivery(userOrder.getOrderDelivery());
            usersOrdersForm.setOrderStatus(userOrder.getOrderStatus());
            if (null != userOrder.getUser()){
                usersOrdersForm.setName(userOrder.getUser().getName());
                usersOrdersForm.setSurname(userOrder.getUser().getSurname());
                usersOrdersForm.setPhoneNumber(userOrder.getUser().getPhoneNumber());
            }
            if(null != userOrder.getOrderFields() || userOrder.getOrderFields().size() > 0){
                List<OrderFieldForm> orderFieldFormList = new ArrayList<>();
                for (OrderField orderField :userOrder.getOrderFields()) {
                    OrderFieldForm orderFieldForm = new OrderFieldForm();
                    orderFieldForm.setId(orderField.getId());
                    orderFieldForm.setQuantityString(Integer.toString(orderField.getQuantity()));
                    orderFieldForm.setInPriceString(Double.toString(orderField.getInPrice().doubleValue()));
                    orderFieldForm.setOutPriceString(Double.toString(orderField.getOutPrice().doubleValue()));
                    if (null != orderField.getProduct()){
                        orderFieldForm.setProductID(orderField.getId());
                        orderFieldForm.setProductName(orderField.getProduct().getProductName());
                        orderFieldForm.setPartNumber(orderField.getProduct().getPartNumber());
                    }
                    orderFieldFormList.add(orderFieldForm);
                }
                usersOrdersForm.setOrderFields(orderFieldFormList);
            }
        }
        return usersOrdersForm;
    }
}
