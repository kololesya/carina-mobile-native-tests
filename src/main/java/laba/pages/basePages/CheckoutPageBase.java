package laba.pages.basePages;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

public abstract class CheckoutPageBase extends BasePage {

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract void fillCheckoutForm(String firstName, String lastName, String zipCode);

    public abstract OverviewPageBase clickContinueButton();

    public abstract ProductsListPageBase clickCancelButton();
}
