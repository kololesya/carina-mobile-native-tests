package laba.pages.ios;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.common.FooterComponent;
import laba.components.common.HeaderMenuComponent;
import laba.components.common.SideMenuComponent;
import laba.components.ios.IOSCartItemComponent;
import laba.components.ios.IOSFooterComponent;
import laba.components.ios.IOSHeaderMenuComponent;
import laba.components.ios.IOSSideMenuComponent;
import laba.pages.base.CartPageBase;
import laba.pages.base.CheckoutPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPageIOS extends CartPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'CHECKOUT'`]")
    private ExtendedWebElement checkoutButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='headerContainer']/..")
    private IOSHeaderMenuComponent headerMenu;

    @FindBy(xpath = "//XCUIElementTypeOther[contains(@name,'All Rights Reserved')]")
    private IOSFooterComponent footerContainer;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Close']/..")
    private IOSSideMenuComponent sideMenuContainer;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    private List<IOSCartItemComponent> productComponents;

    public CartPageIOS(WebDriver driver) {
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

    @Override
    public CheckoutPageBase clickCheckoutButton() {
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }

    @Override
    public boolean isProductInCart(String product) {
        for (IOSCartItemComponent item : productComponents) {
            if (item.getProductName().equalsIgnoreCase(product)) {
                return true;
            }
        }
        return false;
    }
}
