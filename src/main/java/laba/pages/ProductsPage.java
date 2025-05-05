package laba.pages;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPage.class)
public class ProductsPage extends BasePage {

    @ExtendedFindBy(accessibilityId = "test-PRODUCTS")
    private ExtendedWebElement title;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public void openMenu() {
        if (!menuButton.isElementPresent(5)) {
            throw new IllegalStateException("Menu button is not visible!");
        }
        menuButton.click();
    }

    public void logoutButtonClick() {
        if (!logoutButton.isElementPresent(10)) {
            throw new IllegalStateException("Logout button is not present in the side menu!");
        }
        logoutButton.click();
    }

    public LoginPage logout() {
        openMenu();
        logoutButtonClick();
        return new LoginPage(getDriver());
    }
}

