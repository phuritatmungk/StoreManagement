package component;

import java.text.DecimalFormat;

public class ModelItemSell {

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductType(String productType) {
        return productId;
    }

    public void setType() {
        this.productId = productId;
    }
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    

    public ModelItemSell(int productId, String productName, String productType, int qty, double price) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.qty = qty;
        this.price = price;
    }

    public ModelItemSell() {
    }
    private int productId;
    private String productName;
    private String productType;
    private int qty;
    private double price;

    public Object[] toTableRow(int rowNum) {
        DecimalFormat df = new DecimalFormat("#,##0.##");
        Boolean booleanValue = true; 

        return new Object[]{
            null,  
            booleanValue, 
            df.format(rowNum),  
            productId,  
            productName,  
            productType, 
            df.format(qty),  
            "$ " + df.format(price), 
            null  
        };
    }
}