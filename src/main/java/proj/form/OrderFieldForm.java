package proj.form;

/**
 * Created by SC on 13.03.2017.
 */
public class OrderFieldForm {

    private int id;

    private int productID;

    private String productName;

    private String partNumber;

    private String quantityString;

    private String inPriceString;

    private String outPriceString;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getQuantityString() {
        return quantityString;
    }

    public void setQuantityString(String quantityString) {
        this.quantityString = quantityString;
    }

    public String getInPriceString() {
        return inPriceString;
    }

    public void setInPriceString(String inPriceString) {
        this.inPriceString = inPriceString;
    }

    public String getOutPriceString() {
        return outPriceString;
    }

    public void setOutPriceString(String outPriceString) {
        this.outPriceString = outPriceString;
    }
}
