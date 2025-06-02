package laba.components.ios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import laba.components.common.SideMenuComponent;
import laba.constants.MenuButtons;

public class IOSSideMenuComponent extends SideMenuComponent {

    @FindBy(xpath = ".//XCUIElementTypeOther[@name='test-%s']")
    private ExtendedWebElement menuOptionTemplate;

    public IOSSideMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public <T extends AbstractPage> T clickMenuButton(MenuButtons button, Class<T> returnPage) {
        menuOptionTemplate.format(button.getAccessibilityId()).click();
        return initPage(getDriver(), returnPage);
    }
}
