package laba.utils;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import org.openqa.selenium.WebDriver;

public class CustomTypePageFactory {
    public static void initElements(WebDriver driver, Object page) {
        if (page instanceof ICustomTypePageFactory) {
            @SuppressWarnings("unchecked")
            Class<AbstractPage> pageClass = (Class<AbstractPage>) page.getClass();
            ((ICustomTypePageFactory) page).initPage(driver, pageClass);
        } else {
            throw new IllegalArgumentException("Page must implement ICustomTypePageFactory");
        }
    }
}
