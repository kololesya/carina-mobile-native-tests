package laba.pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.android.AndroidFooterComponent;
import laba.pages.base.OrderConfirmationPageBase;
import laba.pages.base.OverviewPageBase;
import laba.utils.ISwipeToFooterUtils;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OverviewPageBase.class)
public class OverviewPageAndroid extends OverviewPageBase implements ISwipeToFooterUtils {

    @ExtendedFindBy(accessibilityId = "test-FINISH")
    private ExtendedWebElement finishButton;

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private ExtendedWebElement overviewTitle;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Sauce Labs. All Rights Reserved')]")
    private AndroidFooterComponent footer;

    public OverviewPageAndroid(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(overviewTitle);
    }

    @Override
    public OrderConfirmationPageBase clickFinishButton() {
        swipeUpToFooter();
        finishButton.click();
        return initPage(getDriver(), OrderConfirmationPageBase.class);
    }

    @Override
    public AndroidFooterComponent getFooter() {
        return footer;
    }
}
