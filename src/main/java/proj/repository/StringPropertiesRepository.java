package proj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.StringProperties;
import proj.service.implementation.specification.StringPropertyFilterAdapter;

import java.util.List;

/**
 * Created by SC on 10.08.2016.
 */
public interface StringPropertiesRepository extends JpaRepository<StringProperties, Integer>, JpaSpecificationExecutor<StringProperties> {
    StringProperties findByPropertyName(String name);

    @Modifying
    @Query("DELETE FROM StringProperties stringProperties WHERE stringProperties.propertyName=:name")
    void deleteByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM StringProperties stringProperties WHERE stringProperties.id=:id")
    void deleteById(@Param("id") int id);

    StringProperties findById(int id);

    @Query("SELECT s FROM StringProperties s LEFT JOIN FETCH s.categoryList WHERE s.id=:id")
    List<StringProperties> findByCategoryId(@Param("id") int id);

    @Query("SELECT DISTINCT sp FROM Product p JOIN p.category c JOIN c.stringPropertiesList sp" +
            " LEFT JOIN FETCH sp.propertyAndValueStrings WHERE p.id=:id")
    List<StringProperties> findByProductId(@Param("id") int id);

    @Query("SELECT DISTINCT sp FROM Product p JOIN p.category c JOIN c.stringPropertiesList sp WHERE p.id=:id")
    List<StringProperties> findStringPropertiesByProductId(@Param("id") int id);


}
