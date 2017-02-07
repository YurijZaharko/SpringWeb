package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import proj.entity.UserOrder;

/**
 * Created by SC on 07.02.2017.
 */
public interface UserOrderRepository extends JpaRepository<UserOrder, Integer>, JpaSpecificationExecutor<UserOrder> {
}
