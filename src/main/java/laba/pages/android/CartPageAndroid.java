package laba.pages.android;

import java.util.*;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.android.AndroidCartItemComponent;
import laba.pages.base.CartPageBase;
import laba.pages.base.CheckoutPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPageAndroid extends CartPageBase {

    @ExtendedFindBy(accessibilityId = "test-REMOVE")
    private List<ExtendedWebElement> removeButtons;

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    @ExtendedFindBy(accessibilityId = "test-Item")
    private List<AndroidCartItemComponent> productComponents;

    public CartPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(checkoutButton);
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
