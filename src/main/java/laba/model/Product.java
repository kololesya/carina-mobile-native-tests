package laba.model;

import java.math.BigDecimal;

public class Product {
    private final String productTitle;
    private final BigDecimal productPrice;

    public Product(String productTitle, BigDecimal productPrice) {
        this.productTitle = productTitle;
        this.productPrice = productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }
}
