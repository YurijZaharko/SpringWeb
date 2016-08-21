package proj.service.implementation;

import org.springframework.stereotype.Service;
import proj.entity.StringProperties;
import proj.service.ProductPropertyService;

import java.util.List;

/**
 * Created by SCIP on 19.08.2016.
 */
@Service
public class ProductPropertyImplement implements ProductPropertyService {
    @Override
    public void save(String name) {

    }

    @Override
    public StringProperties findById(int id) {
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List<StringProperties> findAll() {
        return null;
    }
}
