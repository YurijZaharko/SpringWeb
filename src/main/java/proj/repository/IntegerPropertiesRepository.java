package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proj.entity.IntegerProperties;

/**
 * Created by SC on 10.08.2016.
 */
public interface IntegerPropertiesRepository extends JpaRepository<IntegerProperties, Integer> {
    IntegerProperties findByName(String name);

    @Modifying
    @Query("DELETE FROM IntegerProperties integerProperty WHERE  integerProperty.name=:name")
    void deleteByName(@Param("name") String name);

}
