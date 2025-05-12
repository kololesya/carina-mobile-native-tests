package laba.basePages;

import org.openqa.selenium.WebDriver;

import laba.model.User;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

public abstract class LoginPageBase extends BasePage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract boolean isErrorMessagePresent();

    public abstract String getErrorMessageText();

    public abstract ProductsListPage login(String username, String password);

    public ProductsListPage login(User user) {
        return login(user.getUsername(), user.getPassword());
    }
}
