package laba.pages.ios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.components.common.FooterComponent;
import laba.components.ios.IOSFooterComponent;
import laba.pages.base.OrderConfirmationPageBase;
import laba.pages.base.OverviewPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = OverviewPageBase.class)
public class OverviewPageIOS extends OverviewPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-FINISH'`]")
    private ExtendedWebElement finishButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='CHECKOUT: OVERVIEW']")
    private ExtendedWebElement overviewTitle;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@label, 'All Rights Reserved')]")
    private IOSFooterComponent footerContainer;

    public OverviewPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(overviewTitle);
    }

    @Override
    public OrderConfirmationPageBase clickFinishButton() {
        finishButton.click();
        return initPage(getDriver(), OrderConfirmationPageBase.class);
    }

    @Override
    public FooterComponent getFooter() {
        return footerContainer;
    }
}
