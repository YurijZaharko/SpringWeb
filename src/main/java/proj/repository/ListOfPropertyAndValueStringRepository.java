package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.PropertyAndValueString;

/**
 * Created by SC on 10.08.2016.
 */
public interface ListOfPropertyAndValueStringRepository extends JpaRepository<PropertyAndValueString, Integer> {
}
