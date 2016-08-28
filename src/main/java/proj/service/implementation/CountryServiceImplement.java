package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.Country;
import proj.repository.CountryRepository;
import proj.service.CountryService;

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
}
