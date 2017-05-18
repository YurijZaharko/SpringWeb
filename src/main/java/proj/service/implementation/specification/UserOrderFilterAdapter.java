package proj.service.implementation.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import proj.entity.UserOrder;
import proj.form.Filter.UserOrderFilterForm;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SC on 11.02.2017.
 */
public class UserOrderFilterAdapter implements Specification<UserOrder> {

    private final UserOrderFilterForm userOrderFilterForm;

    private final List<Specification<UserOrder>> filters = new ArrayList<>();

    public UserOrderFilterAdapter(UserOrderFilterForm userOrderFilterForm) {
        if (userOrderFilterForm != null){
            this.userOrderFilterForm = userOrderFilterForm;
        }else {
            this.userOrderFilterForm = new UserOrderFilterForm();
        }
    }

    private void findByOrderId(){
        if(userOrderFilterForm.getOrderId() != 0){
            filters.add(((root, criteriaQuery, criteriaBuilder) -> root.get("id").in(userOrderFilterForm.getOrderId())));
        }
    }

    private void findByPhoneNumber(){
        if(!userOrderFilterForm.getPhoneNumber().isEmpty()){
            filters.add((root, criteriaQuery, criteriaBuilder) -> root.join("user").get("phoneNumber").in(userOrderFilterForm.getPhoneNumber()));
        }
    }

    private void findByOrderDelivery(){
        if(userOrderFilterForm.getOrderDelivery() != null){
            filters.add((root, criteriaQuery, criteriaBuilder) -> root.get("orderDelivery").in(userOrderFilterForm.getOrderDelivery()));
        }
    }

    private void findByProductId(){
        if (userOrderFilterForm.getProductId() != 0){
            filters.add((root, criteriaQuery, criteriaBuilder) -> root.join("orderFields").join("product").get("id").in(userOrderFilterForm.getProductId()));
        }
    }

    @Override
    public Predicate toPredicate(Root<UserOrder> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (criteriaQuery.getResultType() != Long.class && criteriaQuery.getResultType() != long.class) {
            root.fetch("orderFields", JoinType.LEFT).fetch("product", JoinType.LEFT);
            root.fetch("user", JoinType.LEFT);
            criteriaQuery.distinct(true);
        }
        findByOrderId();
        findByPhoneNumber();
        findByOrderDelivery();
        findByProductId();

        if (!filters.isEmpty()){
            Specifications<UserOrder> specification = Specifications.where(filters.get(0));
            for (Specification<UserOrder> s : filters.subList(1, filters.size())){
                specification = specification.and(s);
            }
            return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
        }

        return null;
    }
}
