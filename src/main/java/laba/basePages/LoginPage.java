package laba.basePages;

import org.openqa.selenium.WebDriver;

public abstract class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isErrorMessagePresent();
    public abstract String getErrorMessageText();
    public abstract ProductsListPage login(String username, String password);
}

