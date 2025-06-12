package laba.components.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import laba.components.common.IFooter;

public interface IFooterAndroid extends IFooter {

    @Override
    default AndroidFooterComponent getFooter() {
        By footerLocator = By.xpath("//android.widget.TextView[contains(@text, 'Sauce Labs. All Rights Reserved')]");
        WebElement footerRoot = getDriver().findElement(footerLocator);
        AndroidFooterComponent footer = new AndroidFooterComponent(getDriver(), footerRoot);
        return initFooter(footer, footerRoot);
    }
}
