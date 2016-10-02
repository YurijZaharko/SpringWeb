package proj.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(StringProperties.class)
public abstract class StringProperties_ {

	public static volatile SingularAttribute<StringProperties, String> propertyName;
	public static volatile ListAttribute<StringProperties, Category> categoryList;
	public static volatile SingularAttribute<StringProperties, Integer> id;
	public static volatile ListAttribute<StringProperties, PropertyAndValueString> listOfPropertyAndValueStrings;

}

