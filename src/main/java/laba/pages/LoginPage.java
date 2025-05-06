package laba.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPage.class)
public class LoginPage extends BasePage implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement usernameField;

    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordField;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@content-desc='test-Error message']/android.widget.TextView")
    private ExtendedWebElement errorMessageText;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(loginButton);
    }

    public boolean isErrorMessagePresent() {
        return errorMessageText.isElementPresent();
    }

    public String getErrorMessageText() {
        return errorMessageText.getText();
    }

    public ProductsListPage login(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
        return new ProductsListPage(getDriver());
    }
}
