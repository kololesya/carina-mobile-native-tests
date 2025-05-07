package laba.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterComponent extends AbstractUIObject implements ICustomTypePageFactory {
    @FindBy(xpath = ".//android.widget.TextView[contains(@text,'All Rights Reserved')]")
    private ExtendedWebElement allRightsReservedLabel;

    public FooterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isVisible() {
        return allRightsReservedLabel.isElementPresent(2);
    }

    public ExtendedWebElement getAllRightsReservedLabel() {
        return allRightsReservedLabel;
    }

}
