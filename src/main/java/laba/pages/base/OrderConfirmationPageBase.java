package laba.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class OrderConfirmationPageBase extends BasePage {

    public OrderConfirmationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOrderCompleteMessageDisplayed();

    public abstract String getConfirmationMessage();
}
