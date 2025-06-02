package laba.components.ios;

import java.math.*;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.components.common.ProductComponent;
import laba.model.Product;
import static com.zebrunner.carina.utils.mobile.IMobileUtils.Direction.UP;
import static laba.constants.ProjectConstants.SWIPE_DURATION;
import static laba.constants.ProjectConstants.SWIPE_STEPS;

public class IOSProductComponent extends ProductComponent {

    @FindBy(xpath = ".//XCUIElementTypeStaticText[@name='test-Item title']")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//XCUIElementTypeStaticText[@name='test-Price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//XCUIElementTypeButton[@name='test-ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = ".//XCUIElementTypeButton[@name='test-REMOVE']")
    private ExtendedWebElement removeButton;

    public IOSProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        swipe(productName, UP, SWIPE_STEPS, SWIPE_DURATION);
        return productName.getText().trim();
    }

    public String getProductPrice() {
        swipe(productName, UP, SWIPE_STEPS, SWIPE_DURATION);
        return productPrice.getText().trim();
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickOnProductName() {
        productName.click();
    }

    public Product mapToProduct() {
        String priceText = getProductPrice().replaceAll("[^\\d.,]", "").replace(",", ".");
        BigDecimal price = new BigDecimal(priceText);
        return new Product(getProductName(), price);
    }

    public boolean isRemoveButtonVisible() {
        return removeButton.isElementPresent();
    }
}
