package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proj.entity.StringProperties;

/**
 * Created by SC on 10.08.2016.
 */
public interface StringPropertiesRepository extends JpaRepository<StringProperties, Integer> {
    StringProperties findByPropertyName(String name);

    @Modifying
    @Query("DELETE FROM StringProperties stringProperties WHERE stringProperties.propertyName=:name")
    void deleteByName(@Param("name") String name);
}
