package proj.service.implementation.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import proj.entity.Product;
import proj.form.Filter.ProductFrontFilterForm;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SC on 30.04.2017.
 */
public class ProductFrontFilterAdapter implements Specification<Product> {

    private final ProductFrontFilterForm productFrontFilterForm;

    private final List<Specification<Product>> filters = new ArrayList<>();

    public ProductFrontFilterAdapter(ProductFrontFilterForm productFrontFilterForm) {
        if (productFrontFilterForm != null) {
            this.productFrontFilterForm = productFrontFilterForm;
        }else {
            this.productFrontFilterForm = new ProductFrontFilterForm();
        }
    }

    private void findByPrice(){
        if(productFrontFilterForm.getMinPriceInt() != 0 && productFrontFilterForm.getMaxPriceInt() != 0){
            filters.add((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("price"),
                    productFrontFilterForm.getMinPriceInt(), productFrontFilterForm.getMaxPriceInt()));
        } else if (productFrontFilterForm.getMinPriceInt() != 0){
            filters.add((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.ge(root.get("price"),
                    productFrontFilterForm.getMinPriceInt()));
        } else if (productFrontFilterForm.getMaxPriceInt() != 0){
            filters.add((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.le(root.get("price"),
                    productFrontFilterForm.getMaxPriceInt()));
        }
    }

    private void findByCountry(){
        if (!productFrontFilterForm.getCountryIdList().isEmpty()){
            filters.add((root, criteriaQuery, criteriaBuilder) -> root.get("country").in(productFrontFilterForm.getCountryIdList()));
        }
    }

    private void findByCategoryFilters(){
        if (productFrontFilterForm.getCategoryId() > 0){
            filters.add((root, criteriaQuery, criteriaBuilder) -> root.get("category").in(productFrontFilterForm.getCategoryId()));
        }
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (criteriaQuery.getResultType() != Long.class && criteriaQuery.getResultType() != long.class){
            root.fetch("category", JoinType.LEFT);
            root.fetch("brand", JoinType.LEFT);
            root.fetch("country", JoinType.LEFT);
//            root.fetch("propertyAndValueString", JoinType.LEFT).fetch("valueOfStringPropertiesList", JoinType.LEFT).fetch("stringPropertiesList", JoinType.LEFT);
            criteriaQuery.distinct(true);
        }

        findByPrice();
        findByCountry();
        findByCategoryFilters();

        if (!filters.isEmpty()){
            Specifications<Product> specification = Specifications.where(filters.get(0));
            for (Specification<Product> sp : filters.subList(1, filters.size())){

                specification = specification.and(sp);
            }
            return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
        }

        return null;
    }
}
