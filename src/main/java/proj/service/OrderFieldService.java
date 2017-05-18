package proj.service;

import proj.entity.OrderField;

import java.util.List;

/**
 * Created by SC on 07.02.2017.
 */
public interface OrderFieldService {
    OrderField findById(int id);

    List<OrderField> findOrderFieldByUserOrderId(int id);
}
