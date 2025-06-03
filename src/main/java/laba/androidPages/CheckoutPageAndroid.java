package laba.androidPages;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;

import laba.basePages.CheckoutPageBase;
import laba.basePages.OverviewPageBase;
import laba.basePages.ProductsListPageBase;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPageAndroid extends CheckoutPageBase {

    @ExtendedFindBy(accessibilityId = "test-First Name")
    private ExtendedWebElement firstNameField;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    private ExtendedWebElement lastNameField;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    private ExtendedWebElement zipCodeField;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    private ExtendedWebElement continueButton;

    @ExtendedFindBy(accessibilityId = "test-CANCEL")
    private ExtendedWebElement cancelButton;

    public CheckoutPageAndroid(WebDriver driver) {
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
