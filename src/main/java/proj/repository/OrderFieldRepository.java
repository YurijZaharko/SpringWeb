package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proj.entity.OrderField;

import java.util.List;

/**
 * Created by SC on 07.02.2017.
 */
public interface OrderFieldRepository extends JpaRepository<OrderField, Integer>, JpaSpecificationExecutor<OrderField> {

    @Query(value = "SELECT od FROM OrderField od LEFT JOIN FETCH od.userOrder uo WHERE uo.id=:id")
    List<OrderField> findOrderFieldByUserOrderId(@Param("id") int id);
}
