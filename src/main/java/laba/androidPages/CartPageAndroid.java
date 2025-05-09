package laba.androidPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.basePages.CartPageBase;
import laba.components.android.AndroidFooterComponent;
import laba.components.android.AndroidHeaderMenuComponent;
import laba.components.android.AndroidSideMenuComponent;
import laba.components.common.FooterComponent;
import laba.components.common.HeaderMenuComponent;
import laba.components.common.SideMenuComponent;

public class CartPageAndroid extends CartPageBase {

    @ExtendedFindBy(accessibilityId = "test-REMOVE")
    private List<ExtendedWebElement> removeButtons;

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    @FindBy(xpath = "//android.view.ViewGroup[.//*[@content-desc='test-Menu'] and .//*[@content-desc='test-Cart']]")
    private AndroidHeaderMenuComponent headerMenu;

    @FindBy(xpath = "//android.view.ViewGroup[.//android.widget.TextView[contains(@text,'All Rights Reserved')]]")
    private AndroidFooterComponent footerContainer;

    @FindBy(xpath = "//android.view.ViewGroup[.//*[@content-desc='test-LOGOUT']]")
    private AndroidSideMenuComponent sideMenuContainer;

    public CartPageAndroid (WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(checkoutButton);
    }

    @Override
    public FooterComponent getFooter () {
        return footerContainer;
    }

    @Override
    public SideMenuComponent getSideMenu () {
        return sideMenuContainer;
    }

    @Override
    public HeaderMenuComponent getHeaderMenu () {
        return headerMenu;
    }

    public boolean isCartEmpty() {
        return removeButtons.isEmpty();
    }

    @Override
    public void clickCheckout() {
        checkoutButton.click();
    }
}
