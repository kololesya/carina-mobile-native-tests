package laba.components.android;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.androidPages.CartPageAndroid;
import laba.components.common.HeaderMenuComponent;

public class AndroidHeaderMenuComponent extends HeaderMenuComponent {
    @FindBy(xpath = ".//*[@content-desc='test-Cart']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = ".//*[@content-desc='test-Menu']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']//android.widget.TextView")
    private ExtendedWebElement cartBadge;

    public AndroidHeaderMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPageAndroid clickCartIcon() {
        cartIcon.click();
        return new CartPageAndroid(getDriver());
    }

    public void openSideMenu () {
        menuButton.click();
    }

    @Override
    public boolean isCartBadgeWithCount(int expectedCount) {
        return cartBadge.isElementPresent(5)
                ? cartBadge.getText().trim().equals(String.valueOf(expectedCount))
                : expectedCount == 0;
    }

    @Override
    public boolean isCartIconPresent() {
        return cartIcon.isElementPresent(5);
    }
}
