package proj.service.implementation;

import org.springframework.stereotype.Service;
import proj.entity.ListOfPropertyAndValueInteger;
import proj.service.ListOfPropertyAndValueStringService;

import java.util.List;

/**
 * Created by SCIP on 19.08.2016.
 */
@Service
public class ListOfPropertyAndValueStringImplement implements ListOfPropertyAndValueStringService {
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
