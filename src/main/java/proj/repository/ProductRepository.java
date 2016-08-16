package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.Product;

/**
 * Created by SC on 10.08.2016.
 */
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
