package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proj.entity.PropertyAndValueString;

import java.util.List;

/**
 * Created by SC on 10.08.2016.
 */
public interface PropertyAndValueStringRepository extends JpaRepository<PropertyAndValueString, Integer> {
    PropertyAndValueString findById(int id);

    @Query("SELECT pvs FROM PropertyAndValueString pvs LEFT JOIN FETCH pvs.valueOfStringPropertiesList WHERE pvs.id=:id")
    PropertyAndValueString findByIdWithValue(@Param("id") int id);
}
