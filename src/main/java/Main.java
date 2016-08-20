
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import proj.control.Control;
import proj.control.Scann;
import proj.entity.*;
import proj.service.*;

import java.util.Iterator;
import java.util.List;

/**
 * Created by SCIP on 29.07.2016.
 */
public class Main {

    static final ConfigurableApplicationContext CONTEXT = new ClassPathXmlApplicationContext("/META-INF/applicationContext.xml");
    static final BrandService BRAND_SERVICE = CONTEXT.getBean(BrandService.class);
    static final CountryService COUNTRY_SERVICE = CONTEXT.getBean(CountryService.class);
    static final CategoryService CATEGORY_SERVICE = CONTEXT.getBean(CategoryService.class);
    static final StringPropertiesService STRING_PROPERTIES_SERVICE = CONTEXT.getBean(StringPropertiesService.class);
    static final IntegerPropertiesService INTEGER_PROPERTIES_SERVICE = CONTEXT.getBean(IntegerPropertiesService.class);
    static final ValueOfIntegerPropertiesService VALUE_OF_INTEGER_PROPERTIES_SERVICE = CONTEXT.getBean(ValueOfIntegerPropertiesService.class);
    static final ValueOfStringPropertiesService VALUE_OF_STRING_PROPERTIES_SERVICE = CONTEXT.getBean(ValueOfStringPropertiesService.class);

    public static void main(String[] args) {


        Scann scann = new Scann();
        Control control = new Control(scann);
        boolean isRun = true;
        while (isRun){
            switch (control.mainMenu()){
                case 1: {
                    switch (control.subMenu()){
                        case 1:{
                            BRAND_SERVICE.save(scann.readString("Brand name?"));
                            break;
                        }
                        case 2:{
                            BRAND_SERVICE.delete(scann.readString("Brand name?"));
                            break;
                        }
                        case 3:{
                            Brand brand = BRAND_SERVICE.findByName(scann.readString("Name of item?"));
                            System.out.println(brand);
                            break;
                        }
                        case 4:{
                            List<Brand> brandList= BRAND_SERVICE.findAll();
                            for (Iterator<Brand> iterator = brandList.iterator(); iterator.hasNext(); ) {
                                Brand bran = iterator.next();
                                System.out.println(bran);
                            }
                        }
                        default:{
                            break;
                        }

                    }
                    break;
                }
                case 2: {
                    switch (control.subMenu()){
                        case 1:{
                            COUNTRY_SERVICE.save(scann.readString("Country name?"));
                            break;
                        }
                        case 2:{
                            COUNTRY_SERVICE.delete(scann.readString("Country name?"));
                            break;
                        }
                        case 3:{
                            Country Country = COUNTRY_SERVICE.findByName(scann.readString("Name of item?"));
                            System.out.println(Country);
                            break;
                        }
                        case 4:{
                            List<Country> CountryList= COUNTRY_SERVICE.findAll();
                            for (Iterator<Country> iterator = CountryList.iterator(); iterator.hasNext(); ) {
                                Country bran = iterator.next();
                                System.out.println(bran);
                            }
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    switch (control.subMenu()){
                        case 1:{
                            CATEGORY_SERVICE.save(scann.readString("Category name?"));
                            break;
                        }
                        case 2:{
                            CATEGORY_SERVICE.delete(scann.readString("Category name?"));
                            break;
                        }
                        case 3:{
                            Category Category = CATEGORY_SERVICE.findByName(scann.readString("Name of item?"));
                            System.out.println(Category);
                            break;
                        }
                        case 4:{
                            List<Category> CategoryList= CATEGORY_SERVICE.findAll();
                            for (Iterator<Category> iterator = CategoryList.iterator(); iterator.hasNext(); ) {
                                Category category = iterator.next();
                                System.out.println(category);
                            }
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    switch (control.subMenu()){
                        case 1:{
                            String propertyName = scann.readString("String Property name?");
                            STRING_PROPERTIES_SERVICE.save(propertyName);
                            boolean addValue = true;
                            String valueOfStringProperty = null;
                            ValueOfStringProperties valueOfStringProperties = null;
                            while (addValue){
                                System.out.println("1. Add value");
                                System.out.println("0. Exit");
                                switch (scann.readInt("Choose number")){
                                    case 1:{
                                        valueOfStringProperty = scann.readString("String value?");
                                        VALUE_OF_STRING_PROPERTIES_SERVICE.save(valueOfStringProperty);

                                        valueOfStringProperties = new ValueOfStringProperties(valueOfStringProperty);
                                    }
                                    default:{
                                        addValue = false;
                                    }
                                }
                            }
                            break;
                        }
                        case 2:{
                            STRING_PROPERTIES_SERVICE.delete(scann.readString("String Property name?"));
                            break;
                        }
                        case 3:{
                            StringProperties stringProperties = STRING_PROPERTIES_SERVICE.findByPropertyName(scann.readString("Name of item?"));
                            System.out.println(stringProperties);
                            break;
                        }
                        case 4:{
                            List<StringProperties> StringPropertiesList= STRING_PROPERTIES_SERVICE.findAll();
                            for (StringProperties bran : StringPropertiesList) {
                                System.out.println(bran);
                            }
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                    break;
                }


                case 5: {
                    String propertyName = scann.readString("Integer property name?");
                    IntegerProperties integerProperties = new IntegerProperties(propertyName);
                    INTEGER_PROPERTIES_SERVICE.save(propertyName);
                    boolean addValue = true;
                    Integer valueOfIntegerProperty = null;
                    ValueOfIntegerProperties valueOfIntegerProperties = null;
                    while (addValue){
                        System.out.println("1. Add value");
                        System.out.println("0. Exit");
                        switch (scann.readInt("Choose number")){
                            case 1:{
                                valueOfIntegerProperty = scann.readInt("Integer value?");
                                valueOfIntegerProperties = new ValueOfIntegerProperties(valueOfIntegerProperty);
                                VALUE_OF_INTEGER_PROPERTIES_SERVICE.save(valueOfIntegerProperty);
                            }
                            default:{
                                addValue = false;
                            }
                            integerProperties.getValueOfIntegerPropertiesList().add(valueOfIntegerProperties);
                            INTEGER_PROPERTIES_SERVICE.save(propertyName);
                        }
                    }
                    break;
                }
                case 6:{
                    break;
                }
//
//                case 7: {
//                    String productName = scann.readString("product Name ?");
//                    String partNumber = scann.readString("part Number ?");
//                    int price = scann.readInt("Price ?");
//                    Product product = new Product(price, productName, partNumber);
//
//
//                List<Brand> brandList = entityManager.createQuery("SELECT brand from Brand brand", Brand.class).getResultList();
//                  for (Brand b:brandList) {
//                      System.out.print(b.getBrandName() + ", ");
//                  }
//                   System.out.println();
//                   String brandName = scann.readString("Choose Brand name?");
//                   Brand brand = entityManager.createQuery("SELECT brand FROM Brand brand where brand.brandName=:brandName",
//                           Brand.class).setParameter("brandName",brandName).getSingleResult();
//                   product.setBrand(brand);
//
//                    List<Country> countryList = entityManager.createQuery("SELECT country from Country country", Country.class)
//                            .getResultList();
//                    for (Country c:countryList) {
//                        System.out.print(c + " ");
//                    }
//                    System.out.println();
//                    String countryName = scann.readString("Choose country");
//                    Country country = entityManager.createQuery("SELECT c FROM Country c where c.name=:country",
//                            Country.class).setParameter("country", countryName).getSingleResult();
//                    product.setCountry(country);
//
//                    List<Category> categoryList = entityManager.createQuery("SELECT category from Category category", Category.class)
//                            .getResultList();
//                    for (Category category:categoryList) {
//                        System.out.print(category + " ");
//                    }
//                    System.out.println();
//                    String categoryName = scann.readString("Choose category name");
//                    Category category = entityManager.createQuery("SELECT category FROM Category category where category.categoryName=:category",
//                            Category.class).setParameter("category", categoryName).getSingleResult();
//                    product.setCategory(category);
//                    PRODUCT_DAO.save(product);
//                    break;
//                }

                default:{
                    isRun = false;
                }
            }
        }
    }
}


//    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
//    static EntityManager entityManager = entityManagerFactory.createEntityManager();
//    private static final BrandDao BRAND_DAO = new BrandDaoImplementation(Brand.class, entityManager);
//    private static final CountryDao COUNTRY_DAO = new CountryDaoImplementation(Country.class, entityManager);
//    private static final CategoryDao CATEGORY_DAO = new CategoryDaoImplementation(Category.class, entityManager);
//    private static final StringPropertiesDao STRING_PROPERTIES_DAO = new StringPropertiesDaoImplementation(StringProperties.class, entityManager);
//    private static final ValueOfStringPropertiesDao VALUE_OF_STRING_PROPERTIES_DAO = new ValueOfStringPropertiesDaoImplement(ValueOfStringProperties.class, entityManager);
//    private static final ValueOfIntegerPropertiesDao VALUE_OF_INTEGER_PROPERTIES_DAO = new ValueOfIntegerPropertiesDaoImplement(ValueOfIntegerProperties.class, entityManager);
//    private static final IntegerPropertiesDao INTEGER_PROPERTIES_DAO = new IntegerPropertiesDaoImplementation(IntegerProperties.class, entityManager);
//    private static final ProductDao PRODUCT_DAO = new ProductDaoImplementation(Product.class, entityManager);


////        List<Brand> brandList1 = entityManager.createQuery("SELECT brand FROM Brand brand WHERE (id = 2 or id = 5)", Brand.class)
////                .getResultList();
////        System.out.println(brandList1);
////        System.out.println();
////
////        List<Product> brandList2 = entityManager.createQuery("SELECT product FROM Product product WHERE price between :price1 and :price2", Product.class)
////                .setParameter("price1", 100).setParameter("price2", 5600).getResultList();
////        System.out.println(brandList2);
////        System.out.println();
////
////        List<Product> productList3 = entityManager.createQuery("select product from Product product order by product.price asc ", Product.class)
////                .setFirstResult(0).setMaxResults(2).getResultList();
////        System.out.println(productList3);
////        System.out.println("productList3");
////
////
////        List<Category> categoryListTest = entityManager.createQuery("SELECT category FROM Category category JOIN FETCH category.productList product where product.partNumber=:partNumber",
////                Category.class).setParameter("partNumber", "DTSE9_16GB_(DTSE9H/16GB)").getResultList();
////        System.out.println(categoryListTest);
//
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
//        Root<Product> root = criteriaQuery.from(Product.class);
//        criteriaQuery.select(root);
////        int priceTest = 5600;
////        Predicate predicateEqual = criteriaBuilder.equal(root.get("price"), priceTest);
//
//
////        Predicate predicateIn = root.get("price").in(Arrays.asList(130,5600));
//
//        Join<Product,Brand>  brandJoin = root.join("brand");
//        Predicate countryNameTest = criteriaBuilder.equal(brandJoin.get("brandName"), "ASUS");
//
//        criteriaQuery.where(countryNameTest);
//        List<Product> productList = entityManager.createQuery(criteriaQuery).getResultList();
//        System.out.println(productList);
//        System.out.println();
