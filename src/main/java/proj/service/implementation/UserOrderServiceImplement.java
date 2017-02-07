package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.UserOrder;
import proj.repository.UserOrderRepository;
import proj.service.UserOrderService;

/**
 * Created by SC on 07.02.2017.
 */
@Service
public class UserOrderServiceImplement implements UserOrderService {

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Override
    public UserOrder findById(int id) {
        return userOrderRepository.findOne(id);
    }
}
