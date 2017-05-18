package proj.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Category.class)
public abstract class Category_ {

	public static volatile SingularAttribute<Category, String> name;
	public static volatile ListAttribute<Category, StringProperties> stringPropertiesList;
	public static volatile SingularAttribute<Category, Integer> id;
	public static volatile SingularAttribute<Category, Boolean> rootCategory;
	public static volatile ListAttribute<Category, Category> categoryChild;
	public static volatile SingularAttribute<Category, Category> parentId;
	public static volatile ListAttribute<Category, Product> productList;

}

