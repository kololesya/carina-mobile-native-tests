package laba.pages.ios;

import java.util.*;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.ios.IOSCartItemComponent;
import laba.pages.base.CartPageBase;
import laba.pages.base.CheckoutPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPageIOS extends CartPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'CHECKOUT'`]")
    private ExtendedWebElement checkoutButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    private List<IOSCartItemComponent> productComponents;

    public CartPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(checkoutButton);
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
