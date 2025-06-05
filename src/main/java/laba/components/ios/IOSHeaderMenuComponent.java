package laba.components.ios;

import java.util.*;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.common.HeaderMenuComponent;
import laba.pages.base.CartPageBase;
import static laba.constants.ProjectConstants.PRESENCE_TIMEOUT_SECONDS;
import static laba.utils.DeviceUtils.isUnstableDevice;

public class IOSHeaderMenuComponent extends HeaderMenuComponent {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Cart'`]")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = ".//XCUIElementTypeOther[@name='test-Cart']/XCUIElementTypeOther")
    private ExtendedWebElement cartBadge;

    @FindBy(xpath = ".//XCUIElementTypeOther[@name='test-Menu']")
    private ExtendedWebElement menuButton;

    public IOSHeaderMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CartPageBase clickCartIcon() {
        if (isUnstableDevice()) {
            tapElementWithOffset(cartIcon, 0.8);
        } else {
            cartIcon.click();
        }
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public void openSideMenu() {
        if (isUnstableDevice()) {
            tapElementWithOffset(menuButton, 0.8);
        } else {
            menuButton.click();
        }
    }

    @Override
    public boolean isCartBadgeWithCount(int expectedCount) {
        return cartBadge.isElementPresent(PRESENCE_TIMEOUT_SECONDS)
                ? cartBadge.getText().trim().equals(String.valueOf(expectedCount))
                : expectedCount == 0;
    }

    private void tapElementWithOffset(ExtendedWebElement element, double verticalOffsetPercent) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        int x = location.getX() + size.getWidth() / 2;
        int y = location.getY() + (int) (size.getHeight() * verticalOffsetPercent);
        Map<String, Object> tapParams = new HashMap<>();
        tapParams.put("x", x);
        tapParams.put("y", y);
        tapParams.put("duration", 100);
        ((JavascriptExecutor) getDriver()).executeScript("mobile: tap", tapParams);
    }
}
