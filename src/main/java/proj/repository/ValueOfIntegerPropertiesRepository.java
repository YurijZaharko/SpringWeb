package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.ValueOfIntegerProperties;

/**
 * Created by SC on 10.08.2016.
 */
public interface ValueOfIntegerPropertiesRepository extends JpaRepository<ValueOfIntegerProperties, Integer> {
}
