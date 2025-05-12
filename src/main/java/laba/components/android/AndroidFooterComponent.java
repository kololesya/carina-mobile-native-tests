package laba.components.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import laba.components.common.FooterComponent;

public class AndroidFooterComponent extends FooterComponent {
    @FindBy(xpath = ".//android.widget.TextView[contains(@text,'All Rights Reserved')]")
    private ExtendedWebElement allRightsReservedLabel;

    public AndroidFooterComponent (WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public boolean isVisible() {
        return allRightsReservedLabel.isElementPresent(2);
    }

    public ExtendedWebElement getAllRightsReservedLabel() {
        return allRightsReservedLabel;
    }
}
