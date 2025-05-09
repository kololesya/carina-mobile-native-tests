package laba.model;

public class Product {
    private final String productTitle;
    private final double productPrice;

    public Product(String productTitle, double productPrice) {
        this.productTitle = productTitle;
        this.productPrice = productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public double getProductPrice() {
        return productPrice;
    }
}
