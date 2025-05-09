package laba.components.android;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import laba.components.common.SideMenuComponent;
import laba.constants.MenuButtons;

public class AndroidSideMenuComponent extends SideMenuComponent {

    @FindBy(xpath = ".//*[@content-desc='test-%s']")
    private ExtendedWebElement menuOptionTemplate;

    public AndroidSideMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public <T extends AbstractPage> T clickMenuButton(MenuButtons button, Class<T> returnPage) {
        menuOptionTemplate.format(button.getAccessibilityId()).click();
        return initPage(getDriver(), returnPage);
    }

}
