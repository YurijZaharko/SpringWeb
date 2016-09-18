package proj.service.implementation.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import proj.entity.Product;
import proj.form.Filter.ProductFilterForm;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SCIP on 17.09.2016.
 */
public class ProductFilterAdapter implements Specification<Product> {

    private final ProductFilterForm productFilterForm;

    private final List<Specification<Product>> filters = new ArrayList<>();

    public ProductFilterAdapter(ProductFilterForm productFilterForm) {
        if (productFilterForm != null){
            this.productFilterForm = productFilterForm;
        } else {
            this.productFilterForm = new ProductFilterForm();
        }
    }

    private void findByPrice(){
        if(productFilterForm.getMinInt() != 0 && productFilterForm.getMaxInt() != 0){
            filters.add((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("price"),
                    productFilterForm.getMinInt(), productFilterForm.getMaxInt()));
        } else if (productFilterForm.getMinInt() != 0){
            filters.add((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.ge(root.get("price"),
                    productFilterForm.getMinInt()));
        } else if (productFilterForm.getMaxInt() != 0){
            filters.add((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.le(root.get("price"),
                    productFilterForm.getMaxInt()));
        }
    }

    private void findByCategory(){
        if (!productFilterForm.getCategoryId().isEmpty()){
            filters.add((root, criteriaQuery, criteriaBuilder) -> root.get("category").in(productFilterForm.getCategoryId()));
        }
    }

    private void findByBrand(){
        if (!productFilterForm.getBrandId().isEmpty()){
            filters.add((root, criteriaQuery, criteriaBuilder) -> root.get("brand").in(productFilterForm.getBrandId()));
        }
    }

    private void findByCountry(){
        if (!productFilterForm.getCountryId().isEmpty()){
            filters.add((root, criteriaQuery, criteriaBuilder) -> root.get("country").in(productFilterForm.getCountryId()));
        }
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (criteriaQuery.getResultType() != Long.class && criteriaQuery.getResultType() != long.class) {
            root.fetch("category", JoinType.LEFT);
            root.fetch("brand", JoinType.LEFT);
            root.fetch("country", JoinType.LEFT);
            criteriaQuery.distinct(true);
        }
        findByPrice();
        findByCategory();
        findByBrand();
        findByCountry();

        if (!filters.isEmpty()){
            Specifications<Product> specification = Specifications.where(filters.get(0));
            for (Specification<Product> s : filters.subList(1, filters.size())){
                specification = specification.and(s);
            }
            return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
        }
        return null;
    }
}
