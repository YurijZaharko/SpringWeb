package proj.entity;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> path;
	public static volatile SingularAttribute<Product, Country> country;
	public static volatile SingularAttribute<Product, BigDecimal> price;
	public static volatile ListAttribute<Product, OrderField> orderFields;
	public static volatile SingularAttribute<Product, BigDecimal> sellPrice;
	public static volatile SingularAttribute<Product, String> partNumber;
	public static volatile SingularAttribute<Product, Integer> id;
	public static volatile SingularAttribute<Product, Category> category;
	public static volatile ListAttribute<Product, PropertyAndValueString> propertyAndValueStringList;
	public static volatile SingularAttribute<Product, Integer> version;
	public static volatile SingularAttribute<Product, Brand> brand;
	public static volatile SingularAttribute<Product, String> productName;

}

