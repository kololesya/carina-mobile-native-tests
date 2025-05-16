package laba.androidPages;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.basePages.ProductsListPage;
import laba.components.android.AndroidFooterComponent;
import laba.components.android.AndroidHeaderMenuComponent;
import laba.components.android.AndroidProductComponent;
import laba.components.android.AndroidSideMenuComponent;
import laba.constants.MenuButtons;
import laba.model.Product;
import laba.basePages.LoginPageBase;
import laba.basePages.DrawingPageBase;

import static laba.constants.ProjectConstants.*;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsListPage.class)
public class ProductsListPageAndroid extends ProductsListPage {

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

    public ProductsListPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    public AndroidFooterComponent getFooter() {
        return footerContainer;
    }

    public List<AndroidProductComponent> productListItems () {
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
    public DrawingPageBase drawing() {
        getHeaderMenu().openSideMenu();
        return getSideMenu().clickMenuButton(MenuButtons.DRAWING, DrawingPageBase.class);
    }

    @Override
    public List<String> getAllProductNames() {
        return collectProductValues(AndroidProductComponent::getProductName);
    }

    @Override
    public List<Double> getAllProductPrices() {
        return collectProductValues(pc ->
                Double.parseDouble(
                        pc.getProductPrice()
                                .replaceAll("[^\\d.,]", "")
                                .replace(",", ".")
                )
        );
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
    public void selectSortingOption(String option) {
        sortDropdown.click();
        sortOption.format(option).click();
    }

    @Override
    public void resetAppState() {
        getHeaderMenu().openSideMenu();
        getSideMenu().clickMenuButton(MenuButtons.RESET_APP_STATE, ProductsListPage.class);
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
