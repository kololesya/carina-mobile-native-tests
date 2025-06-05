package laba.pages.ios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.pages.base.LoginPageBase;
import laba.pages.base.ProductsListPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPageIOS extends LoginPageBase {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement usernameField;

    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordField;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'user') or contains(@name, 'required')]")
    private ExtendedWebElement errorMessageText;

    public LoginPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);
    }

    @Override
    public ProductsListPageBase login(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
        return initPage(getDriver(), ProductsListPageBase.class);
    }

    @Override
    public boolean isErrorMessagePresent() {
        return errorMessageText.isElementPresent();
    }

    @Override
    public String getErrorMessageText() {
        return errorMessageText.getText();
    }
}
