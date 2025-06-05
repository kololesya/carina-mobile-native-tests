package laba.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import laba.pages.base.OrderConfirmationPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OrderConfirmationPageBase.class)
public class OrderConfirmationPageAndroid extends OrderConfirmationPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
    private ExtendedWebElement orderCompleteMessage;

    public OrderConfirmationPageAndroid(WebDriver driver) {
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
