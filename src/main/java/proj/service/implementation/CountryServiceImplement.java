package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proj.entity.Country;
import proj.form.CountryFilterForm;
import proj.repository.CountryRepository;
import proj.service.CountryService;
import proj.service.implementation.specification.CountryFilterAdapter;

import java.util.List;

/**
 * Created by SCIP on 11.08.2016.
 */
@Service
public class CountryServiceImplement implements CountryService {

    @Autowired
    CountryRepository countryRepository;
    @Override
    public void save(String name) {
        if(countryRepository.findByName(name) == null){
            Country country = new Country(name);
            countryRepository.save(country);
        }
    }

    @Override
    public Country findByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(int id) {
        return countryRepository.findById(id);
    }

    @Override
    public void save(Country country) {
        if (countryRepository.findByName(country.getName()) == null ){
            countryRepository.save(country);
        }
    }

    @Override
    public Page<Country> findAll(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @Override
    public Page<Country> findAll(Pageable pageable, CountryFilterForm countryFilterForm) {
        return countryRepository.findAll(new CountryFilterAdapter(countryFilterForm), pageable);
    }
}
