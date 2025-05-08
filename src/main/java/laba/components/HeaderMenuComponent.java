package laba.components;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

import laba.androidPages.CartPage;

public class HeaderMenuComponent extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(xpath = ".//*[@content-desc='test-LOGOUT']")
    private ExtendedWebElement logoutButton;

    @FindBy(xpath = ".//*[@content-desc='test-RESET APP STATE']")
    private ExtendedWebElement resetAppStateButton;

    @FindBy(xpath = ".//*[@content-desc='test-Cart']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = ".//*[@content-desc='test-Menu']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']//android.widget.TextView")
    private ExtendedWebElement cartBadge;

    public HeaderMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void logoutButtonClick() {
        logoutButton.click();
    }

    public void resetAppState() {
        resetAppStateButton.click();
    }

    public CartPage clickCartIcon() {
        cartIcon.click();
        return new CartPage(getDriver());
    }

    public void openHeaderMenu () {
        menuButton.click();
    }

    public boolean isCartBadgeWithCount(int expectedCount) {
        return cartBadge.isElementPresent(5)
                ? cartBadge.getText().trim().equals(String.valueOf(expectedCount))
                : expectedCount == 0;
    }

    public boolean isCartIconPresent() {
        return cartIcon.isElementPresent(5);
    }
}
