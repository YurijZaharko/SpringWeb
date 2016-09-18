package proj.service.implementation.specification;

import org.springframework.data.jpa.domain.Specification;
import proj.entity.Product;
import proj.form.ProductFilterForm;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
            filters.add((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("price"), productFilterForm.getMinInt(), productFilterForm.getMaxInt()));
        }
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (criteriaQuery.getResultType() != Long.class && criteriaQuery.getResultType() != long.class) {
            root.fetch("category");
            root.fetch("brand");
            root.fetch("country");
            criteriaQuery.distinct(true);
        }

        return null;
    }
}
