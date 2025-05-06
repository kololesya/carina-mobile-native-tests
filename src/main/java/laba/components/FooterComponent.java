package laba.components;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterComponent extends AbstractUIObject implements ICustomTypePageFactory {

    public FooterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void scrollToFooter() {
        getDriver().findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"© 2025 Sauce Labs. All Rights Reserved.\"))"
                )
        );
    }

    public boolean isFooterVisible() {
        try {
            WebElement footer = getDriver().findElement(
                    MobileBy.AndroidUIAutomator(
                            "new UiSelector().text(\"© 2025 Sauce Labs. All Rights Reserved.\")"
                    )
            );
            return footer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
