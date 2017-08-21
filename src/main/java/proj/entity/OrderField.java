package proj.entity;

import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by SC on 06.02.2017.
 */

@Entity
@BatchSize(size = 50)
@Table(indexes = {@Index(columnList = "outPrice"), @Index(columnList = "inPrice")})
public class OrderField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    private int quantity;

    private BigDecimal inPrice;

    private BigDecimal outPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserOrder userOrder;

    public OrderField() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getOutPrice() {
        return outPrice;
    }

    public void setSellPrice(BigDecimal outPrice) {
        this.outPrice = outPrice;
    }

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    public BigDecimal getInPrice() {
        return inPrice;
    }

    public void setInPrice(BigDecimal inPrice) {
        this.inPrice = inPrice;
    }
}
