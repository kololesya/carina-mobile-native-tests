package laba.pages.basePages;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;

import laba.components.common.FooterComponent;

public abstract class OverviewPageBase extends BasePage {

    public OverviewPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public abstract OrderConfirmationPageBase clickFinishButton();

    public abstract FooterComponent getFooter();
}
