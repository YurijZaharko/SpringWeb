package proj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import proj.entity.Product;
import proj.form.Filter.ProductFilterForm;
import proj.service.implementation.specification.ProductFilterAdapter;

import java.util.List;

/**
 * Created by SC on 10.08.2016.
 */
public interface ProductRepository extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {
    Product findByProductName(String name);

    Product findByPartNumber(String partNumber);

    @Modifying
    @Transactional
    @Query("DELETE FROM Product product WHERE product.id=:id")
    void deleteById(@Param("id") int id);

//    @Query("SELECT DISTINCT * FROM  product LEFT JOIN Product ON product.brand_id =
// brand.id LEFT JOIN country ON product.country_id = country.id")
    @Query("SELECT product FROM Product product LEFT JOIN FETCH product.brand " +
            "LEFT JOIN FETCH product.country LEFT JOIN FETCH product.category")
    List<Product> findAll();

    Product findById(int id);


    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.brand LEFT JOIN FETCH p.country " +
            "LEFT JOIN FETCH p.category WHERE p.id=:id")
    Product findByIdInitAll(@Param("id") int id);

    @Query(value = "SELECT p FROM Product p LEFT JOIN FETCH p.brand LEFT JOIN FETCH p.country " +
            "LEFT JOIN FETCH p.category WHERE p.id=:id",
            countQuery = "SELECT count(p.id) FROM Product p")
    Page<Product> findAll(Pageable pageable);


//    @Query("SELECT DISTINCT p FROM Product p LEFT JOIN FETCH p.category category LEFT JOIN FETCH category.integerPropertiesList integerPropertiesList LEFT JOIN FETCH" +
//            "integerPropertiesList.listOfPropertyAndValueInteger listOfPropertyAndValueInteger LEFT JOIN FETCH listOfPropertyAndValueInteger.valueOfIntegerPropertiesList" +
//            "WHERE product.id=:id"
//    )
//    List<Product> findAllWithValue(@Param("id") int id);
    //            "category.stringPropertiesList stringPropertiesList LEFT JOIN FETCH stringPropertiesList.listOfPropertyAndValueStrings listOfPropertyAndValueStrings LEFT JOIN FETCH" +
//            "listOfPropertyAndValueStrings.valueOfStringPropertiesList"
}
