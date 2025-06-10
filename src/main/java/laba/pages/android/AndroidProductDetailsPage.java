package laba.pages.android;

import java.math.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.model.Product;
import laba.pages.base.ProductDetailsPageBase;
import static com.zebrunner.carina.utils.mobile.IMobileUtils.Direction.UP;
import static laba.constants.ProjectConstants.SWIPE_DURATION;
import static laba.constants.ProjectConstants.SWIPE_STEPS;
import static laba.utils.PriceUtils.extractPrice;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsPageBase.class)
public class AndroidProductDetailsPage extends ProductDetailsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='Add to Cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Remove from Cart']")
    private ExtendedWebElement removeFromCartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-BACK TO PRODUCTS']")
    private ExtendedWebElement backToProductsButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']//android.widget.TextView[contains(@text,'$')]")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Image Container']/android.widget.ImageView")
    private ExtendedWebElement productImage;

    public AndroidProductDetailsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(backToProductsButton);
    }

    @Override
    public String getProductName() {
        return productName.getText();
    }

    @Override
    public Product mapToProduct() {
        swipe(productPrice, UP, SWIPE_STEPS, SWIPE_DURATION);
        String name = getProductName();
        BigDecimal price = extractPrice(productPrice.getText());
        return new Product(name, price);
    }

    @Override
    public boolean isProductImageDisplayed() {
        return productImage.isElementPresent();
    }
}
