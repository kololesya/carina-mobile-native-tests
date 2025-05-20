package laba.components.android;

import java.math.*;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.components.common.ProductComponent;
import laba.model.Product;

public class AndroidProductComponent extends ProductComponent {

    @FindBy(xpath = ".//android.widget.TextView[@content-desc='test-Item title']")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//android.widget.TextView[@content-desc='test-Price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeButton;

    public AndroidProductComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        swipe(productName, Direction.UP, 3, 1000);
        return productName.getText().trim();
    }

    public String getProductPrice() {
        swipe(productName, Direction.UP, 3, 1000);
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
