package laba.components.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import laba.components.common.IHeaderMenu;

public interface IHeaderMenuAndroid extends IHeaderMenu {

    @Override
    default AndroidHeaderMenuComponent getHeaderMenu() {
        By headerLocator = By.xpath("//android.view.ViewGroup[@content-desc='test-Menu']/.."
        );
        WebElement headerRoot = getDriver().findElement(headerLocator);
        AndroidHeaderMenuComponent header =
                new AndroidHeaderMenuComponent(getDriver(), headerRoot);
        return initHeader(header, headerRoot);
    }
}
