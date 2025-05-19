package laba.androidPages;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.basePages.CartPageBase;
import laba.basePages.CheckoutPageBase;
import laba.components.android.AndroidCartItemComponent;
import laba.components.android.AndroidFooterComponent;
import laba.components.android.AndroidHeaderMenuComponent;
import laba.components.android.AndroidSideMenuComponent;
import laba.components.common.FooterComponent;
import laba.components.common.HeaderMenuComponent;
import laba.components.common.SideMenuComponent;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPageAndroid extends CartPageBase {

    @ExtendedFindBy(accessibilityId = "test-REMOVE")
    private List<ExtendedWebElement> removeButtons;

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    @FindBy(xpath = "//*[@content-desc='test-Menu']/..")
    private AndroidHeaderMenuComponent headerMenu;

    @FindBy(xpath = "//android.view.ViewGroup[.//android.widget.TextView[contains(@text,'All Rights Reserved')]]")
    private AndroidFooterComponent footerContainer;

    @FindBy(xpath = "//*[@content-desc='test-Close']/..")
    private AndroidSideMenuComponent sideMenuContainer;

    @ExtendedFindBy(accessibilityId = "test-Item")
    private List<AndroidCartItemComponent> productList;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
    private List<ExtendedWebElement> productTitles;

    public CartPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(checkoutButton);
    }

    @Override
    public FooterComponent getFooter() {
        return footerContainer;
    }

    @Override
    public SideMenuComponent getSideMenu() {
        return sideMenuContainer;
    }

    @Override
    public HeaderMenuComponent getHeaderMenu() {
        return headerMenu;
    }

    public boolean isCartEmpty() {
        return removeButtons.isEmpty();
    }

    @Override
    public CheckoutPageBase clickCheckoutButton() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }

    public boolean isProductInCart(String expectedProductName) {
        return productTitles.stream()
                .map(ExtendedWebElement::getText)
                .anyMatch(text -> text.equalsIgnoreCase(expectedProductName));
    }

//
//    @Override
//    public boolean isProductInCart(String productName) {
//        return productList.stream()
//                .anyMatch(item -> item.getProductName().equalsIgnoreCase(productName));
//    }
}
