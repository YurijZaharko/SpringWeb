package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.PropertyAndValueString;

/**
 * Created by SC on 10.08.2016.
 */
public interface PropertyAndValueStringRepository extends JpaRepository<PropertyAndValueString, Integer> {
}
