package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.entity.ValueOfStringProperties;

/**
 * Created by SC on 10.08.2016.
 */
public interface ValueOfStringPropertiesRepository extends JpaRepository<ValueOfStringProperties, Integer> {
    ValueOfStringProperties findByStringValue(String stringValue);

}
