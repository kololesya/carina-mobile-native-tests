package laba.components.ios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.common.HeaderMenuComponent;
import laba.pages.base.CartPageBase;
import static laba.constants.ProjectConstants.PRESENCE_TIMEOUT_SECONDS;
import static laba.constants.ProjectConstants.VERTICAL_OFFSET_PERCENT;
import static laba.utils.DeviceUtils.isUnstableDevice;
import static laba.utils.SearchElementUtil.tapElementWithOffset;

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
            tapElementWithOffset(cartIcon, VERTICAL_OFFSET_PERCENT);
        } else {
            cartIcon.click();
        }
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public void openSideMenu() {
        if (isUnstableDevice()) {
            tapElementWithOffset(menuButton, VERTICAL_OFFSET_PERCENT);
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
}
