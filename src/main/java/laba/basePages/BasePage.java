package laba.basePages;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import laba.components.HeaderMenuComponent;

public abstract class BasePage extends AbstractPage implements ICustomTypePageFactory {

    @FindBy(xpath = "//android.view.ViewGroup[.//*[@content-desc='test-Menu'] and .//*[@content-desc='test-Cart']]")
    private HeaderMenuComponent headerMenu;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public HeaderMenuComponent getHeaderMenu() {
        return headerMenu;
    }
}
