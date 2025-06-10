package laba.pages.base;

import org.openqa.selenium.WebDriver;

import laba.components.common.FooterComponent;

public abstract class OverviewPageBase extends BasePage {

    public OverviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract OrderConfirmationPageBase clickFinishButton();

    public abstract FooterComponent getFooter();
}
