package laba.pages.ios;

import java.math.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.model.Product;
import laba.pages.base.ProductDetailsPageBase;
import static laba.utils.PriceUtils.extractPrice;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductDetailsPageBase.class)
public class ProductDetailsPageIOS extends ProductDetailsPageBase {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Add To Cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Remove']")
    private ExtendedWebElement removeFromCartButton;

    @ExtendedFindBy(accessibilityId = "test-BACK TO PRODUCTS")
    private ExtendedWebElement backToProductsButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Description'`]/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement productName;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeImage")
    private ExtendedWebElement productImage;

    public ProductDetailsPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(backToProductsButton);
    }

    @Override
    public String getProductName() {
        System.out.println(productName.getText());
        return productName.getText();
    }

    @Override
    public Product mapToProduct() {
        String name = getProductName();
        BigDecimal price = extractPrice(productPrice.getText());
        return new Product(name, price);
    }

    @Override
    public boolean isProductImageDisplayed() {
        return productImage.isElementPresent();
    }
}
