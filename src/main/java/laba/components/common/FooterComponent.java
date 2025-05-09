package laba.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FooterComponent extends AbstractComponent{

    public FooterComponent (WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract boolean isVisible();
}
