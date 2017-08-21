package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proj.entity.ValueOfStringProperties;

import java.util.List;

/**
 * Created by SC on 10.08.2016.
 */
public interface ValueOfStringPropertiesRepository extends JpaRepository<ValueOfStringProperties, Integer> {

    ValueOfStringProperties findByStringValue(String stringValue);

    ValueOfStringProperties findById(int id);

    @Query("SELECT DISTINCT vsp FROM ValueOfStringProperties vsp LEFT JOIN vsp.propertyAndValueStrings pvs LEFT JOIN pvs.stringProperties spl WHERE spl.id=:id")
    List<ValueOfStringProperties> findValueOfStringPropertiesByStringPropertiesId(@Param("id") int id);
}
