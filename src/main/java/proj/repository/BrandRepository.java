package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.Brand;

/**
 * Created by SC on 10.08.2016.
 */
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    Brand findByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Brand brand WHERE brand.name=:name" )
    void deleteByName(@Param("name") String name);
}
