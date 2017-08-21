package proj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.UserOrder;

/**
 * Created by SC on 07.02.2017.
 */
public interface UserOrderRepository extends JpaRepository<UserOrder, Integer>, JpaSpecificationExecutor<UserOrder> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM UserOrder us WHERE us.orderStatus IS NULL")
    void deleteByUserOrderNULL();

    @Query(value = "SELECT uo FROM UserOrder uo LEFT JOIN FETCH uo.orderFields orderField LEFT JOIN FETCH orderField.product LEFT JOIN FETCH uo.user",
    countQuery = "SELECT COUNT(uo.id) FROM UserOrder uo")
    Page<UserOrder> findAllFetchOrderFields(Pageable pageable);

    @Query(value = "SELECT uo FROM UserOrder uo LEFT JOIN FETCH uo.orderFields orderField LEFT JOIN FETCH orderField.product LEFT JOIN FETCH uo.user " +
            "WHERE uo.id=:id")
    UserOrder findOneFetch(@Param("id") int id);
}
