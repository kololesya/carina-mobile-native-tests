package laba.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

public class ProductItemComponent extends AbstractUIObject implements ICustomTypePageFactory {
    @ExtendedFindBy(accessibilityId = "test-Item title")
    private ExtendedWebElement productName;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    public ProductItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickOnProductName() {
        productName.click();
    }

    public void removeFromCart() {
        addToCartButton.click();
    }

    public boolean isAddToCartVisible() {
        return addToCartButton.isElementPresent();
    }
}
