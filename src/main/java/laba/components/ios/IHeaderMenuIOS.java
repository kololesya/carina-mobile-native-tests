package laba.components.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import laba.components.common.IHeaderMenu;

public interface IHeaderMenuIOS extends IHeaderMenu {

    @Override
    default IOSHeaderMenuComponent getHeaderMenu() {
        By headerLocator = By.xpath("//XCUIElementTypeOther[@name='headerContainer']/..");
        WebElement headerRoot = getDriver().findElement(headerLocator);
        IOSHeaderMenuComponent header =
                new IOSHeaderMenuComponent(getDriver(), headerRoot);
        return initHeader(header, headerRoot);
    }
}
