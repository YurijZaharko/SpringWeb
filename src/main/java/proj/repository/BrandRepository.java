package proj.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import proj.entity.Brand;
import proj.form.BrandFilterForm;
import proj.service.implementation.specification.BrandFilterAdapter;

/**
 * Created by SC on 10.08.2016.
 */

public interface BrandRepository extends JpaRepository<Brand,Integer>, JpaSpecificationExecutor<Brand> {
    Brand findByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Brand brand WHERE brand.id=:id" )
    void deleteById(@Param("id") int id);


    Brand findById(int id);


}
