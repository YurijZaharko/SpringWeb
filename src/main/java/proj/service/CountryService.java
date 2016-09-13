package proj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proj.entity.Country;
import proj.form.CountryFilterForm;

import java.util.List;

/**
 * Created by SCIP on 11.08.2016.
 */

public interface CountryService  {

    void save(String name);

    Country findByName(String name);

    void deleteById(int id);

    List<Country> findAll();

    Country findById(int id);

    void save(Country country);

    Page<Country> findAll(Pageable pageable);

    Page<Country> findAll(Pageable pageable, CountryFilterForm countryFilterForm);
}
