package laba.components.ios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.components.common.CartItemComponent;

public class IOSCartItemComponent extends CartItemComponent {

    @FindBy(xpath = ".//XCUIElementTypeStaticText[contains(@name, 'Description')]")
    private ExtendedWebElement title;

    public IOSCartItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getProductName() {
        return title.getText().trim();
    }
}
