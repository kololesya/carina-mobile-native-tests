package laba.androidPages;

import java.math.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.basePages.ProductDetailsPageBase;
import laba.components.android.AndroidFooterComponent;
import laba.components.android.AndroidHeaderMenuComponent;
import laba.model.Product;
import static laba.constants.ProjectConstants.SWIPE_DURATION;
import static laba.constants.ProjectConstants.SWIPE_STEPS;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsPageBase.class)
public class ProductDetailsPageAndroid extends ProductDetailsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='Add to Cart']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Remove from Cart']")
    private ExtendedWebElement removeFromCartButton;

    @FindBy(xpath = "//*[@content-desc='test-Menu']/..")
    private AndroidHeaderMenuComponent headerMenu;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Sauce Labs. All Rights Reserved')]")
    private AndroidFooterComponent footerContainer;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-BACK TO PRODUCTS']")
    private ExtendedWebElement backToProductsButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
    private ExtendedWebElement productName;

//    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
//    private ExtendedWebElement productName;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']//android.widget.TextView[contains(@text,'$')]")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Image Container']/android.widget.ImageView")
    private ExtendedWebElement productImage;

    public ProductDetailsPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(backToProductsButton);
    }

    @Override
    public void addToCart() {
        addToCartButton.click();
    }

    @Override
    public void removeFromCart() {
        removeFromCartButton.click();
    }

    @Override
    public boolean isAddToCartVisible() {
        swipeUpToFooter();
        return addToCartButton.isElementPresent();
    }

    @Override
    public boolean isRemoveFromCartVisible() {
        swipeUpToFooter();
        return removeFromCartButton.isElementPresent();
    }

    @Override
    public String getProductName() {
        return productName.getText();
    }

    @Override
    public String getPrice() {
        return productPrice.getText();
    }

    @Override
    public Product mapToProduct() {
        swipe(productPrice, Direction.UP, 3, 1000);
        String name = getProductName();
        String priceText = productPrice.getText().replaceAll("[^\\d.,]", "").replace(",", ".");
        BigDecimal price = new BigDecimal(priceText);
        return new Product(name, price);
    }

    @Override
    public boolean isProductImageDisplayed() {
        swipe(productImage, Direction.UP, 2, 1000); // если вдруг не видно
        return productImage.isElementPresent() && productImage.isVisible();
    }

    public AndroidHeaderMenuComponent getHeaderMenu() {
        return headerMenu;
    }

    public AndroidFooterComponent getFooter() {
        return footerContainer;
    }

    private void swipeUpToFooter() {
        swipe(getFooter().getAllRightsReservedLabel(), Direction.UP, SWIPE_STEPS, SWIPE_DURATION);
    }
}
