package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import proj.entity.ListOfPropertiesInteger;

/**
 * Created by SC on 10.08.2016.
 */
public interface ListOfPropertiesIntegerRepository extends JpaRepository<ListOfPropertiesInteger, Integer> {

    @Query("SELECT listOfPropertiesInteger FROM ListOfPropertiesInteger listOfPropertiesInteger JOIN listOfPropertiesInteger.category category WHERE category.name=:name")
    ListOfPropertiesInteger findByCategoryName(@Param("name") String name);
}
