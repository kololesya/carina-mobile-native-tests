package laba.androidPages;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.basePages.ProductsListPage;
import laba.components.FooterComponent;
import laba.components.ProductComponent;
import laba.model.Product;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsListPage.class)
public class ProductsListPageAndroid extends ProductsListPage implements IMobileUtils {
    @ExtendedFindBy(accessibilityId = "test-PRODUCTS")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement sortDropdown;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement sortOption;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductComponent> productComponentList;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']//android.widget.TextView")
    private ExtendedWebElement cartBadge;

    @FindBy(xpath = "//android.view.ViewGroup[.//android.widget.TextView[contains(@text,'All Rights Reserved')]]")
    private FooterComponent footerContainer;

    public ProductsListPageAndroid(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public FooterComponent getFooter() {
        return footerContainer;
    }

    public List<ProductComponent> getProductItems() {
        return productComponentList;
    }

    public LoginPageAndroid logout() {
        getHeaderMenu().openMenu();
        getHeaderMenu().logoutButtonClick();
        return new LoginPageAndroid(getDriver());
    }

    @Override
    public List<String> getAllProductNames() {
        Set<String> uniqueNames = new LinkedHashSet<>();
        int safetyCounter = 10;
        while (!getFooter().isVisible() && safetyCounter-- > 0) {
            for (ProductComponent productItem : getProductItems()) {
                uniqueNames.add(productItem.getProductName());
            }
            swipe(getFooter().getAllRightsReservedLabel(), Direction.UP, 2, 600);
        }
        return new ArrayList<>(uniqueNames);
    }

    @Override
    public List<Double> getAllProductPrices() {
        Set<Double> uniquePrices = new LinkedHashSet<>();
        int safetyCounter = 10;
        while (!getFooter().isVisible() && safetyCounter-- > 0) {
            for (ProductComponent productItem : getProductItems()) {
                String raw = productItem.getProductPrice();
                String clean = raw.replaceAll("[^\\d.,]", "").replace(",", ".");
                uniquePrices.add(Double.parseDouble(clean));
            }
            swipe(getFooter().getAllRightsReservedLabel(), Direction.UP, 2, 600);
        }
        return new ArrayList<>(uniquePrices);
    }

    public boolean areAllProductNamesVisible() {
        List<Product> uniqueProducts = new ArrayList<>();
        while (!getFooter().isVisible()) {
            for (ProductComponent productItem : getProductItems()) {
                Product product = productItem.toModel();
                boolean isNew = uniqueProducts.stream()
                        .noneMatch(p -> p.getProductTitle().equals(product.getProductTitle()));
                if (isNew) {
                    uniqueProducts.add(product);
                }
            }
            swipe(getFooter().getAllRightsReservedLabel(), Direction.UP, 2, 600);
        }
        return uniqueProducts.stream()
                .allMatch(p -> p.getProductTitle() != null && !p.getProductTitle().isEmpty()
                        && p.getProductPrice() > 0);
    }

    public void addProductToCartByName(String productName) {
        ProductComponent item = getProductItems().stream()
                .filter(p -> p.getProductName().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Product not found: " + productName));
        item.clickAddToCart();
    }

    @Override
    public void selectSortingOption(String option) {
        sortDropdown.click();
        sortOption.format(option).click();
    }

    public void resetAppState() {
        getHeaderMenu().openMenu();
        getHeaderMenu().resetAppState();
    }

    public boolean isCartBadgeWithCount(int expectedCount) {
        if (!cartBadge.isElementPresent(5)) {
            return expectedCount == 0;
        }
        return cartBadge.getText().trim().equals(String.valueOf(expectedCount));
    }

    public void swipeUntilVisible(ExtendedWebElement element, int maxSwipes) {
        int attempts = 0;
        while (!element.isElementPresent(1) && attempts < maxSwipes) {
            swipe(500, 1500, 500, 500, 1000);
            attempts++;
            pause(1);
        }
    }
}
