package proj.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, Country> country;
	public static volatile SingularAttribute<Product, Integer> price;
	public static volatile SingularAttribute<Product, ProductProperty> productProperty;
	public static volatile SingularAttribute<Product, String> partNumber;
	public static volatile SingularAttribute<Product, Integer> id;
	public static volatile SingularAttribute<Product, Category> category;
	public static volatile SingularAttribute<Product, Brand> brand;
	public static volatile SingularAttribute<Product, String> productName;

}

