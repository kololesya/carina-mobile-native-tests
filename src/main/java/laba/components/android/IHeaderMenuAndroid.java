package laba.components.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedFieldDecorator;
import com.zebrunner.carina.webdriver.locator.ExtendedElementLocatorFactory;

import laba.components.common.IHeaderMenu;
import static com.zebrunner.agent.core.webdriver.RemoteWebDriverFactory.getDriver;

public interface IHeaderMenuAndroid extends IHeaderMenu {

    @Override
    default AndroidHeaderMenuComponent getHeaderMenu() {
        By headerLocator = By.xpath("//android.view.ViewGroup[@content-desc='test-Menu']/.."
        );
        WebElement headerRoot = getDriver().findElement(headerLocator);
        AndroidHeaderMenuComponent header =
                new AndroidHeaderMenuComponent(getDriver(), headerRoot);
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
