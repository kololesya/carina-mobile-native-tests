package laba.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends BasePage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CheckoutPageBase clickCheckoutButton();

    public abstract boolean isProductInCart(String productName);
}
