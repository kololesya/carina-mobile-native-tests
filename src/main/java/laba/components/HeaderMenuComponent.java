package laba.components;

import laba.androidPages.CartPage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class HeaderMenuComponent extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(xpath = ".//*[@content-desc='test-LOGOUT']")
    private ExtendedWebElement logoutButton;

    @FindBy(xpath = ".//*[@content-desc='test-RESET APP STATE']")
    private ExtendedWebElement resetAppStateButton;

    @FindBy(xpath = ".//*[@content-desc='test-Cart']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = ".//*[@content-desc='test-Menu']")
    private ExtendedWebElement menuButton;

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

    public void openMenu() {
        menuButton.click();
    }
}
