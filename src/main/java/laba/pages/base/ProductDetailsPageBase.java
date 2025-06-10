package laba.pages.base;

import org.openqa.selenium.WebDriver;

import laba.model.Product;

public abstract class ProductDetailsPageBase extends BasePage {

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductName();

    public abstract Product mapToProduct();

    public abstract boolean isProductImageDisplayed();
}
