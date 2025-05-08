package laba.androidPages;

import java.util.*;
import java.util.function.Function;

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


import static laba.constants.ProjectConstants.*;

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

    @Override
    public LoginPageBaseAndroid logout() {
        getHeaderMenu().openHeaderMenu();
        getHeaderMenu().logoutButtonClick();
        return new LoginPageBaseAndroid(getDriver());
    }

    @Override
    public List<String> getAllProductNames() {
        return collectProductValues(ProductComponent::getProductName);
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
                .allMatch(p -> p.getProductTitle() != null && !p.getProductTitle().isEmpty()
                        && p.getProductPrice() > 0);
    }

    private List<Product> collectAllProducts() {
        Set<String> seenTitles = new HashSet<>();
        List<Product> collected = new ArrayList<>();

        while (!getFooter().isVisible()) {
            for (ProductComponent item : getProductItems()) {
                Product product = item.toModel();
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
            Optional<ProductComponent> target = getProductItems().stream()
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
        getHeaderMenu().openHeaderMenu();
        getHeaderMenu().resetAppState();
    }

    private void swipeUpToFooter() {
        swipe(getFooter().getAllRightsReservedLabel(), Direction.UP, SWIPE_STEPS, SWIPE_DURATION);
    }

    private <T> List<T> collectProductValues(Function<ProductComponent, T> extractor) {
        Set<T> uniqueValues = new LinkedHashSet<>();
        while (!getFooter().isVisible()) {
            for (ProductComponent productItem : getProductItems()) {
                uniqueValues.add(extractor.apply(productItem));
            }
            swipeUpToFooter();
        }
        return new ArrayList<>(uniqueValues);
    }
}
