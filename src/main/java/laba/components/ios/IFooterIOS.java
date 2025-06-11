package laba.components.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedFieldDecorator;
import com.zebrunner.carina.webdriver.locator.ExtendedElementLocatorFactory;

import laba.components.common.IFooter;

public interface IFooterIOS extends IFooter, IMobileUtils {

    @Override
    default IOSFooterComponent getFooter() {
        By footerTextLocator = By.xpath("//XCUIElementTypeStaticText[contains(@name, 'Sauce Labs. All Rights Reserved')]");
        WebElement footerRoot = getDriver().findElement(footerTextLocator);
        IOSFooterComponent footer = new IOSFooterComponent(getDriver(), footerRoot);
        PageFactory.initElements(
                new ExtendedFieldDecorator(
                        new ExtendedElementLocatorFactory(getDriver(), footerRoot),
                        getDriver()
                ),
                footer
        );
        return footer;
    }
}
