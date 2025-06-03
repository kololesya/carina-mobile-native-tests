package laba.components.ios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.components.common.HeaderMenuComponent;
import laba.pages.ios.CartPageIOS;
import static laba.constants.ProjectConstants.PRESENCE_TIMEOUT_SECONDS;

public class IOSHeaderMenuComponent extends HeaderMenuComponent {

    @FindBy(xpath = ".//XCUIElementTypeOther[@name='test-Cart']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = ".//XCUIElementTypeOther[@name='test-Cart']/XCUIElementTypeOther")
    private ExtendedWebElement cartBadge;

    @FindBy(xpath = ".//XCUIElementTypeOther[@name='test-Menu']")
    private ExtendedWebElement menuButton;

    public IOSHeaderMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CartPageIOS clickCartIcon() {
        cartIcon.click();
        return new CartPageIOS(getDriver());
    }

    @Override
    public void openSideMenu() {
        menuButton.click();
    }

    @Override
    public boolean isCartBadgeWithCount(int expectedCount) {
        return cartBadge.isElementPresent(PRESENCE_TIMEOUT_SECONDS)
                ? cartBadge.getText().trim().equals(String.valueOf(expectedCount))
                : expectedCount == 0;
    }
}
