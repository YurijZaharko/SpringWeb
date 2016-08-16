package proj.service;

import proj.entity.Country;

import java.util.List;

/**
 * Created by SCIP on 11.08.2016.
 */

public interface CountryService  {
    void save(String name);
    Country findByName(String name);
    void delete(String name);
    List<Country> findAll();
}
