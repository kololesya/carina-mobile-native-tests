package laba.components.common;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

import laba.constants.MenuButtons;

public abstract class SideMenuComponent extends AbstractComponent {

    public SideMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract <T extends AbstractPage> T clickMenuButton(MenuButtons button, Class<T> returnPage);

}
