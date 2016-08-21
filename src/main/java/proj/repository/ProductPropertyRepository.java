package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.ProductProperty;

/**
 * Created by SCIP on 19.08.2016.
 */
public interface ProductPropertyRepository extends JpaRepository<ProductProperty, Integer>{}
