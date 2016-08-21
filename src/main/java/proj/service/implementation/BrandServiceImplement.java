package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.entity.Brand;
import proj.repository.BrandRepository;
import proj.service.BrandService;

import java.util.List;

/**
 * Created by SC on 10.08.2016.
 */
@Service
public class BrandServiceImplement implements BrandService{

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void save(String name) {
        if(brandRepository.findByName(name) == null){
            Brand brand = new Brand(name);
            brandRepository.save(brand);
        }
    }

    @Override
    public Brand findByName(String name) {
        return brandRepository.findByName(name);
    }

    @Override
    public void delete(String name) {
        brandRepository.deleteByName(name);
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }
}
