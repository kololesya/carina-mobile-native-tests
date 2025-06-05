package laba.components.ios;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.common.CartItemComponent;

public class IOSCartItemComponent extends CartItemComponent {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Description'`]/XCUIElementTypeStaticText[1]")
    private ExtendedWebElement productTitle;

    public IOSCartItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getProductName() {
        return productTitle.getText().trim();
    }
}
