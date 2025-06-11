package laba.components.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedFieldDecorator;
import com.zebrunner.carina.webdriver.locator.ExtendedElementLocatorFactory;

import laba.components.common.IHeaderMenu;

public interface IHeaderMenuIOS extends IHeaderMenu, IMobileUtils {

    @Override
    default IOSHeaderMenuComponent getHeaderMenu() {
        By headerLocator = By.xpath("//XCUIElementTypeOther[@name='headerContainer']/..");
        WebElement headerRoot = getDriver().findElement(headerLocator);
        IOSHeaderMenuComponent header =
                new IOSHeaderMenuComponent(getDriver(), headerRoot);
        PageFactory.initElements(
                new ExtendedFieldDecorator(
                        new ExtendedElementLocatorFactory(getDriver(), headerRoot),
                        getDriver()
                ),
                header
        );
        return header;
    }
}
