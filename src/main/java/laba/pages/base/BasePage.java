package laba.pages.base;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public abstract class BasePage extends AbstractPage implements ICustomTypePageFactory, IMobileUtils {

    public BasePage(WebDriver driver) {
        super(driver);
    }
}
