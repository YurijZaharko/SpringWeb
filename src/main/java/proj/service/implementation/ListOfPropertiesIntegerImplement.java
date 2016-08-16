package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.ListOfPropertiesInteger;
import proj.repository.CategoryRepository;
import proj.repository.ListOfPropertiesIntegerRepository;
import proj.service.ListOfPropertiesIntegerService;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
@Service
public class ListOfPropertiesIntegerImplement implements ListOfPropertiesIntegerService {
    @Autowired
    ListOfPropertiesIntegerRepository listOfPropertiesIntegerRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void save(String categoryName) {
        listOfPropertiesIntegerRepository.save(new ListOfPropertiesInteger(categoryRepository.findByName(categoryName)));
    }

    @Override
    public ListOfPropertiesInteger findByCategoryName(String name) {
        return listOfPropertiesIntegerRepository.findByCategoryName(name);
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<ListOfPropertiesInteger> findAll() {
        return null;
    }
}
