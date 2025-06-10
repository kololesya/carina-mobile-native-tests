package laba.pages.base;

import org.openqa.selenium.WebDriver;

import laba.model.User;

public abstract class LoginPageBase extends BasePage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isErrorMessagePresent();

    public abstract String getErrorMessageText();

    public abstract ProductsListPageBase login(String username, String password);

    public ProductsListPageBase login(User user) {
        return login(user.getUsername(), user.getPassword());
    }
}
