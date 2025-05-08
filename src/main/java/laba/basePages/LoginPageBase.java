package laba.basePages;

import org.openqa.selenium.WebDriver;

import laba.model.User;

public abstract class LoginPageBase extends BasePage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isErrorMessagePresent();

    public abstract String getErrorMessageText();

    public abstract ProductsListPage login(String username, String password);

    public ProductsListPage login(User user) {
        return login(user.getUsername(), user.getPassword());
    }
}
