package laba.components.ios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.components.common.FooterComponent;
import static laba.constants.ProjectConstants.PRESENCE_TIMEOUT_SECONDS;

public class IOSFooterComponent extends FooterComponent {

    @FindBy(xpath = ".//XCUIElementTypeStaticText[contains(@name,'All Rights Reserved')]")
    private ExtendedWebElement allRightsReservedLabel;

    public IOSFooterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public boolean isVisible() {
        return allRightsReservedLabel.isElementPresent(PRESENCE_TIMEOUT_SECONDS);
    }

    public ExtendedWebElement getAllRightsReservedLabel() {
        return allRightsReservedLabel;
    }
}
