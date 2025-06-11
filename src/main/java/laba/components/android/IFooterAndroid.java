package laba.components.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedFieldDecorator;
import com.zebrunner.carina.webdriver.locator.ExtendedElementLocatorFactory;

import laba.components.common.IFooter;

public interface IFooterAndroid extends IFooter, IMobileUtils {

    @Override
    default AndroidFooterComponent getFooter() {
        By footerLocator = By.xpath("//android.widget.TextView[contains(@text, 'Sauce Labs. All Rights Reserved')]");
        WebElement footerRoot = getDriver().findElement(footerLocator);
        AndroidFooterComponent footer = new AndroidFooterComponent(getDriver(), footerRoot);
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
