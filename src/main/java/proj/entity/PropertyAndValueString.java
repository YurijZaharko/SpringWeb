package proj.entity;

import javax.persistence.*;

/**
 * Created by SCIP on 31.07.2016.
 */
@Entity
public class PropertyAndValueString {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private StringProperties stringProperties;

    @ManyToOne(fetch = FetchType.LAZY)
    private ValueOfStringProperties valueOfStringProperties;

    public PropertyAndValueString() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StringProperties getStringProperties() {
        return stringProperties;
    }

    public void setStringProperties(StringProperties stringProperties) {
        this.stringProperties = stringProperties;
    }

    public ValueOfStringProperties getValueOfStringProperties() {
        return valueOfStringProperties;
    }

    public void setValueOfStringProperties(ValueOfStringProperties valueOfStringProperties) {
        this.valueOfStringProperties = valueOfStringProperties;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
