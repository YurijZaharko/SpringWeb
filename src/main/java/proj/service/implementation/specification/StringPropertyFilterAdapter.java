package proj.service.implementation.specification;

import org.springframework.data.jpa.domain.Specification;
import proj.entity.StringProperties;
import proj.form.Filter.StringPropertiesFilterForm;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by SCIP on 12.12.2016.
 */
public class StringPropertyFilterAdapter implements Specification<StringProperties> {

    private String search = "";

    public StringPropertyFilterAdapter(StringPropertiesFilterForm stringPropertiesFilterForm){search = stringPropertiesFilterForm.getSearch();}

    @Override
    public Predicate toPredicate(Root<StringProperties> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.upper(root.get("propertyName")), search.toUpperCase() + "%");
    }
}
