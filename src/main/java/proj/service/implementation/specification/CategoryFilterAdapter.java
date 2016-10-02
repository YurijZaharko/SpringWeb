package proj.service.implementation.specification;

import org.springframework.data.jpa.domain.Specification;
import proj.entity.Category;
import proj.form.Filter.CategoryFilterForm;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by SC on 02.10.2016.
 */
public class CategoryFilterAdapter implements Specification<Category> {

    private String search = "";

    public CategoryFilterAdapter(CategoryFilterForm categoryFilterForm){search = categoryFilterForm.getSearch();}

    @Override
    public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), search.toUpperCase() + "%");
    }
}
