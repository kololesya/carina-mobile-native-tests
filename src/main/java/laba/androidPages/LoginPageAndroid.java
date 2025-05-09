package laba.androidPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.basePages.LoginPageBase;
import laba.basePages.ProductsListPage;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPageAndroid extends LoginPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement usernameField;

    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordField;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
    private ExtendedWebElement errorMessageText;

    public LoginPageAndroid (WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(loginButton);
    }

    @Override
    public ProductsListPage login(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
        return initPage(getDriver(), ProductsListPage.class);
    }

    public boolean isErrorMessagePresent() {
        return errorMessageText.isElementPresent();
    }

    public String getErrorMessageText() {
        return errorMessageText.getText();
    }
}

