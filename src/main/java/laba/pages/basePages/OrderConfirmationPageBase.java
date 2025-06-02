package laba.pages.basePages;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

public abstract class OrderConfirmationPageBase extends BasePage {

    public OrderConfirmationPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract boolean isOrderCompleteMessageDisplayed();

    public abstract String getConfirmationMessage();
}
