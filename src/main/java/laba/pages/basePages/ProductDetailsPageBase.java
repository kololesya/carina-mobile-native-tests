package laba.pages.basePages;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

import laba.model.Product;

public abstract class ProductDetailsPageBase extends BasePage {

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract String getProductName();

    public abstract Product mapToProduct();

    public abstract boolean isProductImageDisplayed();
}
