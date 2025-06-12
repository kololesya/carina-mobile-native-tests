package laba.components.ios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.common.ProductComponent;

public class IOSProductComponent extends ProductComponent {

    @FindBy(xpath = ".//XCUIElementTypeStaticText[@name='test-Item title']")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//XCUIElementTypeStaticText[@name='test-Price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//XCUIElementTypeOther[@name='test-ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(accessibilityId = "test-REMOVE")
    private ExtendedWebElement removeButton;

    public IOSProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    protected ExtendedWebElement getProductNameElement() {
        return productName;
    }

    @Override
    protected ExtendedWebElement getProductPriceElement() {
        return productPrice;
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickOnProductName() {
        productName.click();
    }

    public boolean isRemoveButtonVisible() {
        return removeButton.isElementPresent();
    }
}
