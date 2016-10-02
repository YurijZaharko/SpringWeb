package proj.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IntegerProperties.class)
public abstract class IntegerProperties_ {

	public static volatile SingularAttribute<IntegerProperties, String> name;
	public static volatile ListAttribute<IntegerProperties, Category> categoryList;
	public static volatile ListAttribute<IntegerProperties, PropertyAndValueInteger> propertyAndValueInteger;
	public static volatile SingularAttribute<IntegerProperties, Integer> id;

}

