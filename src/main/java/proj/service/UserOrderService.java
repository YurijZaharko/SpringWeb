package proj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.entity.UserOrder;
import proj.form.Filter.UserOrderFilterForm;
import proj.form.UsersOrdersForm;

/**
 * Created by SC on 07.02.2017.
 */
public interface UserOrderService {

    UserOrder findById(int id);

    Page<UserOrder> findAll(Pageable pageable, UserOrderFilterForm userOrderFilterForm);

    Page<UserOrder> findAllFetch(Pageable pageable, UserOrderFilterForm userOrderFilterForm);

    UsersOrdersForm addProduct(UsersOrdersForm usersOrdersForm);

    UsersOrdersForm createNewOrder();

    void save(UsersOrdersForm usersOrdersForm);

    UsersOrdersForm findUserOrdersFormById(int id);
}
