package laba.pages.base;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

import laba.model.User;

public abstract class LoginPageBase extends BasePage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract boolean isErrorMessagePresent();

    public abstract String getErrorMessageText();

    public abstract ProductsListPageBase login(String username, String password);

    public ProductsListPageBase login(User user) {
        return login(user.getUsername(), user.getPassword());
    }
}
