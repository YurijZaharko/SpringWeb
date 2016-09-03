package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.ProductProperty;
import proj.entity.StringProperties;

/**
 * Created by SCIP on 19.08.2016.
 */
public interface ProductPropertyRepository extends JpaRepository<ProductProperty, Integer>{
    ProductProperty findById(int id);

    void deleteById(int id);
}
