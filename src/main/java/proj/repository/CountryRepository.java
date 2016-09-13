package proj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.Country;
import proj.service.implementation.specification.CountryFilterAdapter;

/**
 * Created by SC on 10.08.2016.
 */
public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country> {
    Country findByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Country country WHERE country.id=:id")
    void deleteById(@Param("id") int id);

    Country findById(int id);


}
