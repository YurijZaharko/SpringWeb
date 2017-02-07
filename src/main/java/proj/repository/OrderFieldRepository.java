package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import proj.entity.OrderField;

/**
 * Created by SC on 07.02.2017.
 */
public interface OrderFieldRepository extends JpaRepository<OrderField, Integer>, JpaSpecificationExecutor<OrderField> {
}
