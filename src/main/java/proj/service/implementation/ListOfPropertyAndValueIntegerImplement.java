package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.ListOfPropertyAndValueInteger;
import proj.repository.CategoryRepository;
import proj.repository.ListOfPropertyAndValueIntegerRepository;
import proj.service.ListOfPropertyAndValueIntegerService;

import java.util.List;

/**
 * Created by SCIP on 12.08.2016.
 */
@Service
public class ListOfPropertyAndValueIntegerImplement implements ListOfPropertyAndValueIntegerService {
    @Autowired
    ListOfPropertyAndValueIntegerRepository listOfPropertyAndValueIntegerRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void save() {

    }

    @Override
    public ListOfPropertyAndValueInteger findByCategoryName(String name) {
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<ListOfPropertyAndValueInteger> findAll() {
        return null;
    }
}
