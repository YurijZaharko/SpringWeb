package proj.service.implementation.specification;

import org.springframework.data.jpa.domain.Specification;
import proj.entity.User;
import proj.form.Filter.UserFilterForm;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by SC on 05.01.2017.
 */
public class UserFilterAdapter implements Specification<User> {

    private String search = "";

    public UserFilterAdapter(UserFilterForm userFilterForm){this.search = userFilterForm.getSearch();}

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), search.toUpperCase() + "%");
    }
}
