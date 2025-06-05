package laba.pages.ios;

import java.math.*;
import java.util.*;
import java.util.stream.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.ios.IOSFooterComponent;
import laba.components.ios.IOSHeaderMenuComponent;
import laba.components.ios.IOSProductComponent;
import laba.components.ios.IOSSideMenuComponent;
import laba.constants.MenuButtons;
import laba.model.Product;
import laba.pages.base.DrawingPageBase;
import laba.pages.base.LoginPageBase;
import laba.pages.base.ProductDetailsPageBase;
import laba.pages.base.ProductsListPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsListPageBase.class)
public class ProductsListPageIOS extends ProductsListPageBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='headerContainer']/..")
    private IOSHeaderMenuComponent headerMenu;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='PRODUCTS']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Item']")
    private List<IOSProductComponent> productList;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Sauce Labs. All Rights Reserved')]")
    private IOSFooterComponent footer;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Close']/..")
    private IOSSideMenuComponent sideMenu;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement sortDropdown;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='%s']")
    private ExtendedWebElement sortOption;

    public ProductsListPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(title);
    }

    @Override
    public ProductDetailsPageBase openProductByName(String productName) {
        for (IOSProductComponent product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                product.clickOnProductName();
                return initPage(getDriver(), ProductDetailsPageBase.class);
            }
        }
        throw new NoSuchElementException("Product not found: " + productName);
    }

    @Override
    public List<String> getAllProductNames() {
        List<String> names = new ArrayList<>();
        for (IOSProductComponent item : productList) {
            names.add(item.getProductName());
        }
        return names;
    }

    @Override
    public List<BigDecimal> getAllProductPrices() {
        return productList.stream()
                .map(IOSProductComponent::getProductPrice)
                .collect(Collectors.toList());
    }

    @Override
    public IOSFooterComponent getFooter() {
        return footer;
    }

    @Override
    public IOSSideMenuComponent getSideMenu() {
        return sideMenu;
    }

    @Override
    public IOSHeaderMenuComponent getHeaderMenu() {
        return headerMenu;
    }

    @Override
    public Product getProductFromListByName(String productName) {
        for (IOSProductComponent item : productList) {
            if (item.getProductName().equalsIgnoreCase(productName)) {
                return item.mapToProduct();
            }
        }
        throw new NoSuchElementException("Product not found: " + productName);
    }

    @Override
    public void selectSortingOption(String option) {
        sortDropdown.click();
        sortOption.format(option).click();
    }

    @Override
    public LoginPageBase logout() {
        getHeaderMenu().openSideMenu();
        return getSideMenu().clickMenuButton(MenuButtons.LOGOUT, LoginPageBase.class);
    }

    @Override
    public void addProductToCartByName(String productName) {
        for (IOSProductComponent item : productList) {
            if (item.getProductName().equalsIgnoreCase(productName)) {
                item.clickAddToCart();
                return;
            }
        }
        throw new NoSuchElementException("Product not found: " + productName);
    }

    @Override
    public void resetAppState() {
        getHeaderMenu().openSideMenu();
        getSideMenu().clickMenuButton(MenuButtons.RESET_APP_STATE, ProductsListPageBase.class);
    }

    @Override
    public DrawingPageBase openDrawingPage() {
        getHeaderMenu().openSideMenu();
        return getSideMenu().clickMenuButton(MenuButtons.DRAWING, DrawingPageBase.class);
    }

    @Override
    public boolean areAllProductNamesVisible() {
        return productList.stream().allMatch(p ->
                p.getProductName() != null &&
                        !p.getProductName().isEmpty() &&
                        p.getProductPrice().compareTo(BigDecimal.ZERO) > 0);
    }

    @Override
    public String getTitle() {
        return title.getAttribute("name");
    }

    @Override
    public boolean isRemoveButtonVisibleForProduct(String productName) {
        for (IOSProductComponent product : productList) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product.isRemoveButtonVisible();
            }
        }
        return false;
    }
}
