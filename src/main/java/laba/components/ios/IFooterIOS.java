package laba.components.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import laba.components.common.IFooter;

public interface IFooterIOS extends IFooter {

    @Override
    default IOSFooterComponent getFooter() {
        By footerTextLocator = By.xpath("//XCUIElementTypeStaticText[contains(@name, 'Sauce Labs. All Rights Reserved')]");
        WebElement footerRoot = getDriver().findElement(footerTextLocator);
        IOSFooterComponent footer = new IOSFooterComponent(getDriver(), footerRoot);
        return initFooter(footer, footerRoot);
    }
}
