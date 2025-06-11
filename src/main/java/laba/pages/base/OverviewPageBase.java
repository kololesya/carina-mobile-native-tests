package laba.pages.base;

import org.openqa.selenium.WebDriver;

import laba.components.common.IFooter;

public abstract class OverviewPageBase extends BasePage implements IFooter {

    public OverviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract OrderConfirmationPageBase clickFinishButton();
}
