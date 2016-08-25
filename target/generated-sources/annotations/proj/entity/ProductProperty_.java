package proj.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductProperty.class)
public abstract class ProductProperty_ {

	public static volatile ListAttribute<ProductProperty, ListOfPropertyAndValueInteger> listOfPropertyAndValueIntegers;
	public static volatile SingularAttribute<ProductProperty, Integer> id;
	public static volatile ListAttribute<ProductProperty, Product> productList;
	public static volatile ListAttribute<ProductProperty, ListOfPropertyAndValueString> listOfPropertyAndValueStrings;

}

