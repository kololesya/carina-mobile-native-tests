package laba.pages.ios;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.pages.base.CheckoutPageBase;
import laba.pages.base.OverviewPageBase;
import laba.pages.base.ProductsListPageBase;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPageIOS extends CheckoutPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-First Name'`]")
    private ExtendedWebElement firstNameField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-Last Name'`]")
    private ExtendedWebElement lastNameField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-Zip/Postal Code'`]")
    private ExtendedWebElement zipCodeField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CONTINUE'`]")
    private ExtendedWebElement continueButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CANCEL'`]")
    private ExtendedWebElement cancelButton;

    public CheckoutPageIOS(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(continueButton);
    }

    @Override
    public void fillCheckoutForm(String firstName, String lastName, String zipCode) {
        firstNameField.type(firstName);
        lastNameField.type(lastName);
        zipCodeField.type(zipCode);
    }

    @Override
    public OverviewPageBase clickContinueButton() {
        continueButton.click();
        return initPage(getDriver(), OverviewPageBase.class);
    }

    @Override
    public ProductsListPageBase clickCancelButton() {
        cancelButton.click();
        return initPage(getDriver(), ProductsListPageBase.class);
    }
}
