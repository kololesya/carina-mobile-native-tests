package laba.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

public class AbstractComponent extends AbstractUIObject implements IMobileUtils, ICustomTypePageFactory {

    public AbstractComponent (WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
