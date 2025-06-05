package laba.pages.ios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.pages.base.OrderConfirmationPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = OrderConfirmationPageBase.class)
public class OrderConfirmationPageIOS extends OrderConfirmationPageBase {

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='THANK YOU FOR YOU ORDER']")
    private ExtendedWebElement orderCompleteMessage;

    public OrderConfirmationPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(orderCompleteMessage);
    }

    @Override
    public boolean isOrderCompleteMessageDisplayed() {
        return orderCompleteMessage.isElementPresent();
    }

    @Override
    public String getConfirmationMessage() {
        return orderCompleteMessage.getText();
    }
}
