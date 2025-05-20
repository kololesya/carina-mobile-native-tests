package laba.basePages;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

import laba.model.Product;

public abstract class ProductDetailsPageBase extends BasePage {

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract void addToCart();

    public abstract void removeFromCart();

    public abstract boolean isAddToCartVisible();

    public abstract boolean isRemoveFromCartVisible();

    public abstract String getProductName();

    public abstract String getPrice();

    public abstract Product mapToProduct();

    public abstract boolean isProductImageDisplayed();
}
