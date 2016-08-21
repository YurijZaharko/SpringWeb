package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.Country;

/**
 * Created by SC on 10.08.2016.
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Country country WHERE country.name=:name")
    void deleteByName(@Param("name") String name);
}
