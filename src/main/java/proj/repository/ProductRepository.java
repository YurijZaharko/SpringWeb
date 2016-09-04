package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import proj.entity.Product;

import java.util.List;

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

//    @Query("SELECT DISTINCT * FROM  product LEFT JOIN Product ON product.brand_id = brand.id LEFT JOIN country ON product.country_id = country.id")
    @Query("SELECT product FROM Product product LEFT JOIN FETCH product.brand LEFT JOIN FETCH product.country LEFT JOIN FETCH product.category")
    List<Product> findAll();

    Product findById(int id);

    @Query("SELECT p FROM Product p  LEFT JOIN FETCH p.brand LEFT JOIN FETCH p.country LEFT JOIN FETCH p.productProperty LEFT JOIN FETCH p.category WHERE p.id=:id")
    Product findByIdInitAll(@Param("id") int id);
}
