package laba.pages.android;

import java.math.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.android.AndroidFooterComponent;
import laba.components.android.AndroidHeaderMenuComponent;
import laba.components.android.AndroidProductComponent;
import laba.components.android.AndroidSideMenuComponent;
import laba.constants.MenuButtons;
import laba.model.Product;
import laba.pages.base.DrawingPageBase;
import laba.pages.base.LoginPageBase;
import laba.pages.base.ProductDetailsPageBase;
import laba.pages.base.ProductsListPageBase;
import static laba.constants.ProjectConstants.MAX_SCROLL_ATTEMPTS;
import static laba.constants.ProjectConstants.SWIPE_DURATION;
import static laba.constants.ProjectConstants.SWIPE_STEPS;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsListPageBase.class)
public class AndroidProductsListPage extends ProductsListPageBase {

    @FindBy(xpath = "//*[@content-desc='test-Menu']/..")
    private AndroidHeaderMenuComponent headerMenu;

    @ExtendedFindBy(accessibilityId = "test-PRODUCTS")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement sortDropdown;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement sortOption;

    @ExtendedFindBy(accessibilityId = "test-Item")
    private List<AndroidProductComponent> androidProductComponentList;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Sauce Labs. All Rights Reserved')]")
    private AndroidFooterComponent footerContainer;

    @FindBy(xpath = "//*[@content-desc='test-Close']/..")
    private AndroidSideMenuComponent sideMenuContainer;

    public AndroidProductsListPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    public AndroidFooterComponent getFooter() {
        return footerContainer;
    }

    public List<AndroidProductComponent> productListItems() {
        return androidProductComponentList;
    }

    public AndroidSideMenuComponent getSideMenu() {
        return sideMenuContainer;
    }

    public AndroidHeaderMenuComponent getHeaderMenu() {
        return headerMenu;
    }

    @Override
    public LoginPageBase logout() {
        getHeaderMenu().openSideMenu();
        return getSideMenu().clickMenuButton(MenuButtons.LOGOUT, LoginPageBase.class);
    }

    @Override
    public DrawingPageBase openDrawingPage() {
        getHeaderMenu().openSideMenu();
        return getSideMenu().clickMenuButton(MenuButtons.DRAWING, DrawingPageBase.class);
    }

    @Override
    public ProductDetailsPageBase openProductByName(String productName) {
        int safetyCounter = MAX_SCROLL_ATTEMPTS;
        while (safetyCounter-- > 0) {
            for (AndroidProductComponent product : productListItems()) {
                if (product.getProductName().equalsIgnoreCase(productName)) {
                    product.clickOnProductName();
                    return initPage(getDriver(), ProductDetailsPageBase.class);
                }
            }
            if (getFooter().isVisible()) break;
            swipeUpToFooter();
        }
        throw new IllegalStateException("Product not found for opening: " + productName);
    }

    @Override
    public List<String> getAllProductNames() {
        return collectProductValues(AndroidProductComponent::getProductName);
    }

    @Override
    public List<BigDecimal> getAllProductPrices() {
        return androidProductComponentList.stream()
                .map(AndroidProductComponent::getProductPrice)
                .collect(Collectors.toList());
    }

    @Override
    public boolean areAllProductNamesVisible() {
        List<Product> products = collectAllProducts();
        return products.stream()
                .allMatch(p -> p.getProductTitle() != null
                        && !p.getProductTitle().isEmpty()
                        && p.getProductPrice().compareTo(BigDecimal.ZERO) > 0);
    }

    private List<Product> collectAllProducts() {
        Set<String> seenTitles = new HashSet<>();
        List<Product> collected = new ArrayList<>();
        while (!getFooter().isVisible()) {
            for (AndroidProductComponent item : productListItems()) {
                Product product = item.mapToProduct();
                if (seenTitles.add(product.getProductTitle())) {
                    collected.add(product);
                }
            }
            swipeUpToFooter();
        }
        return collected;
    }

    @Override
    public void addProductToCartByName(String productName) {
        int safetyCounter = MAX_SCROLL_ATTEMPTS;
        while (safetyCounter-- > 0) {
            Optional<AndroidProductComponent> target = productListItems().stream()
                    .filter(p -> p.getProductName().equalsIgnoreCase(productName))
                    .findFirst();
            if (target.isPresent()) {
                target.get().clickAddToCart();
                return;
            }
            if (getFooter().isVisible()) break;
            swipeUpToFooter();
        }
        throw new IllegalStateException("Product not found after scrolling: " + productName);
    }

    @Override
    public Product getProductFromListByName(String productName) {
        int safetyCounter = MAX_SCROLL_ATTEMPTS;
        while (safetyCounter-- > 0) {
            Optional<AndroidProductComponent> target = productListItems().stream()
                    .filter(p -> p.getProductName().equalsIgnoreCase(productName))
                    .findFirst();
            if (target.isPresent()) {
                return target.get().mapToProduct();
            }
            if (getFooter().isVisible()) break;
            swipeUpToFooter();
        }
        throw new NoSuchElementException("Product not found: " + productName);
    }

    @Override
    public void selectSortingOption(String option) {
        sortDropdown.click();
        sortOption.format(option).click();
    }

    @Override
    public void resetAppState() {
        getHeaderMenu().openSideMenu();
        getSideMenu().clickMenuButton(MenuButtons.RESET_APP_STATE, ProductsListPageBase.class);
    }

    @Override
    public boolean isRemoveButtonVisibleForProduct(String productName) {
        int safetyCounter = MAX_SCROLL_ATTEMPTS;
        while (safetyCounter-- > 0) {
            Optional<AndroidProductComponent> target = productListItems().stream()
                    .filter(p -> p.getProductName().equalsIgnoreCase(productName))
                    .findFirst();
            if (target.isPresent()) {
                return target.get().isRemoveButtonVisible();
            }
            if (getFooter().isVisible()) break;
            swipeUpToFooter();
        }
        throw new IllegalStateException("Product not found after scrolling: " + productName);
    }

    private void swipeUpToFooter() {
        swipe(getFooter().getAllRightsReservedLabel(), Direction.UP, SWIPE_STEPS, SWIPE_DURATION);
    }

    private <T> List<T> collectProductValues(Function<AndroidProductComponent, T> extractor) {
        Set<T> uniqueValues = new LinkedHashSet<>();
        while (!getFooter().isVisible()) {
            for (AndroidProductComponent productItem : productListItems()) {
                uniqueValues.add(extractor.apply(productItem));
            }
            swipeUpToFooter();
        }
        return new ArrayList<>(uniqueValues);
    }

    @Override
    public String getTitle() {
        return title.getAttribute("content-desc");
    }
}
