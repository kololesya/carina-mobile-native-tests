package laba.androidPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.basePages.OrderConfirmationPageBase;
import laba.basePages.OverviewPageBase;
import laba.components.android.AndroidFooterComponent;
import static laba.constants.ProjectConstants.SWIPE_DURATION;
import static laba.constants.ProjectConstants.SWIPE_STEPS;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = OverviewPageBase.class)
public class OverviewPageAndroid extends OverviewPageBase {

    @ExtendedFindBy(accessibilityId = "test-FINISH")
    private ExtendedWebElement finishButton;

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private ExtendedWebElement overviewTitle;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Sauce Labs. All Rights Reserved')]")
    private AndroidFooterComponent footerContainer;

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

    public AndroidFooterComponent getFooter() {
        return footerContainer;
    }

    private void swipeUpToFooter() {
        swipe(getFooter().getAllRightsReservedLabel(), Direction.UP, SWIPE_STEPS, SWIPE_DURATION);
    }
}
