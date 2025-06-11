// src/main/java/laba/components/common/IComponentInitializer.java
package laba.components.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedFieldDecorator;
import com.zebrunner.carina.webdriver.locator.ExtendedElementLocatorFactory;

public interface IComponentInitializer extends IMobileUtils {

    default <T> T initComponent(T component, WebElement root) {
        PageFactory.initElements(
                new ExtendedFieldDecorator(
                        new ExtendedElementLocatorFactory(getDriver(), root),
                        getDriver()
                ),
                component
        );
        return component;
    }
}
