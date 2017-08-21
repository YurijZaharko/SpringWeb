package proj.service.implementation.specification;

import org.springframework.data.jpa.domain.Specification;
import proj.entity.Brand;
import proj.form.Filter.BrandFilterForm;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by SCIP on 15.09.2016.
 */
public class BrandFilterAdapter implements Specification<Brand> {

    private String search = "";

    public BrandFilterAdapter(BrandFilterForm brandFilterForm) {
        this.search = brandFilterForm.getSearch();
    }

    @Override
    public Predicate toPredicate(Root<Brand> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), search.toUpperCase() + "%");
    }
}
