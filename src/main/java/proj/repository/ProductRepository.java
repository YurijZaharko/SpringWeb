package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import proj.entity.Product;

/**
 * Created by SC on 10.08.2016.
 */
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByProductName(String name);

    Product findByPartNumber(String partNumber);

    @Modifying
    @Transactional
    @Query("DELETE FROM Product product WHERE product.id=:id")
    void deleteById(@Param("id") int id);
}
