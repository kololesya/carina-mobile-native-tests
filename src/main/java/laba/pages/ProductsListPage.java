package laba.pages;

import java.util.*;
import java.util.stream.Collectors;

import io.appium.java_client.MobileBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.ProductItemComponent;
import laba.components.FooterComponent;
import laba.constants.SortType;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsListPage.class)
public class ProductsListPage extends BasePage implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-PRODUCTS")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    @ExtendedFindBy(accessibilityId = "test-RESET APP STATE")
    private ExtendedWebElement resetAppStateButton;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement sortDropdown;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement sortOption;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductItemComponent> productItems;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']//android.widget.TextView")
    private ExtendedWebElement cartBadge;

    @FindBy(xpath = "//android.view.ViewGroup[@class='android.view.ViewGroup' and .//android.widget.TextView[contains(@text,'© 2025 Sauce Labs')]]")
    private FooterComponent footer;

    public ProductsListPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public FooterComponent getFooter() {
        return footer;
    }

    public List<ProductItemComponent> getProductItems() {
        return productItems;
    }

    public void openMenu() {
        menuButton.click();
    }

    public void logoutButtonClick() {
        logoutButton.click();
    }

    public LoginPage logout() {
        openMenu();
        logoutButtonClick();
        return new LoginPage(getDriver());
    }

    public List<String> getProductNames() {
        return productItems.stream()
                .map(ProductItemComponent::getProductName)
                .collect(Collectors.toList());
    }

    public List<Double> getProductPrices() {
        return productItems.stream()
                .map(ProductItemComponent::getProductPrice)
                .map(text -> Double.parseDouble(text.replace("$", "").trim()))
                .collect(Collectors.toList());
    }

    public void addProductToCartByName(String productName) {
        ProductItemComponent item = productItems.stream()
                .filter(p -> p.getProductName().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Product not found: " + productName));
        item.clickAddToCart();
    }

    public void selectSortingOption(String option) {
        sortDropdown.click();
        sortOption.format(option).click();
    }

    public <T extends Comparable<T>> boolean isSorted(List<T> list, SortType sortType) {
        List<T> sorted = new ArrayList<>(list);
        switch (sortType) {
            case NAME_A_TO_Z:
            case PRICE_LOW_TO_HIGH:
                Collections.sort(sorted);
                break;
            case NAME_Z_TO_A:
            case PRICE_HIGH_TO_LOW:
                Collections.sort(sorted, Collections.reverseOrder());
                break;
        }
        return sorted.equals(list);
    }

    public CartPage clickCartIcon() {
        cartIcon.click();
        return new CartPage(getDriver());
    }

    public void resetAppState() {
        openMenu();
        resetAppStateButton.click();
    }

    public boolean isCartBadgeWithCount(int expectedCount) {
        if (!cartBadge.isElementPresent(5)) {
            return expectedCount == 0;
        }
        return cartBadge.getText().trim().equals(String.valueOf(expectedCount));
    }

    public void scrollToLastProduct() {
        getDriver().findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"Test.allTheThings() T-Shirt (Red)\"))"
                )
        );
    }

    public void scrollToFooter() {
        footer.scrollToFooter();
    }
}
