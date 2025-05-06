package laba.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

public class CartPage extends BasePage implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-Cart badge")
    private ExtendedWebElement cartBadge;

    @ExtendedFindBy(accessibilityId = "test-REMOVE")
    private List<ExtendedWebElement> removeButtons;

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(checkoutButton);
    }

    public boolean isCartEmpty() {
        return removeButtons.isEmpty();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

}
