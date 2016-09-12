package proj.service.implementation.specification;

import org.springframework.data.jpa.domain.Specification;
import proj.entity.Country;
import proj.form.CountryFilterForm;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by SC on 12.09.2016.
 */
public class CountryFilterAdapter implements Specification<Country> {

    private String search = "";

    public CountryFilterAdapter(CountryFilterForm countryFilterForm){
        search = countryFilterForm.getSearch();
    }

    @Override
    public Predicate toPredicate(Root<Country> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (criteriaQuery.getResultType() != Long.class && criteriaQuery.getResultType() != long.class){

        }
        return criteriaBuilder.like(criteriaBuilder.upper(root.<String>get("name")), search.toUpperCase() + "%");
    }
}
