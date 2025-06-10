package laba.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public abstract class FooterComponent extends AbstractComponent {

    public FooterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract boolean isVisible();

    public abstract ExtendedWebElement getAllRightsReservedLabel();
}
