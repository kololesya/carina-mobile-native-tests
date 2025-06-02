package laba.pages.androidPages;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.android.AndroidCartItemComponent;
import laba.components.android.AndroidFooterComponent;
import laba.components.android.AndroidHeaderMenuComponent;
import laba.components.android.AndroidSideMenuComponent;
import laba.components.common.FooterComponent;
import laba.components.common.HeaderMenuComponent;
import laba.components.common.SideMenuComponent;
import laba.pages.basePages.CartPageBase;
import laba.pages.basePages.CheckoutPageBase;

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

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView")
    private List<ExtendedWebElement> productTitles;

    @ExtendedFindBy(accessibilityId = "test-Item")
    private List<AndroidCartItemComponent> productComponents;

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

    @Override
    public boolean isProductInCart(String product) {
        for (AndroidCartItemComponent item : productComponents) {
            if (item.getProductName().equals(product)) {
                return true;
            }
        }
        return false;
    }
}
