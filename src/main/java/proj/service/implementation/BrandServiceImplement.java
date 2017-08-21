package proj.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proj.entity.Brand;
import proj.form.Filter.BrandFilterForm;
import proj.repository.BrandRepository;
import proj.service.BrandService;
import proj.service.implementation.specification.BrandFilterAdapter;

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
    public Brand findById(int id) {
        return brandRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public void save(Brand brand) {
        if (brandRepository.findByName(brand.getName()) == null){
            brandRepository.save(brand);
        }
    }

    @Override
    public Page<Brand> findAll(Pageable pageable, BrandFilterForm brandFilterForm) {
        return brandRepository.findAll(new BrandFilterAdapter(brandFilterForm), pageable);
    }
}
