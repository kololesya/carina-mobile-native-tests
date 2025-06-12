package laba.pages.base;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends BasePage {

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillCheckoutForm(String firstName, String lastName, String zipCode);

    public abstract OverviewPageBase clickContinueButton();

    public abstract ProductsListPageBase clickCancelButton();
}
