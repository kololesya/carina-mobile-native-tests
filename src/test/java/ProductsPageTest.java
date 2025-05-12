import laba.basePages.ProductsListPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.zebrunner.agent.core.registrar.TestRunRegistrar.LOGGER;

public class ProductsPageTest extends BaseTest {

    @Test
    public void testProductListIsDisplayedAfterLogin() {
        ProductsListPage productsPage = loginAsStandardUser();
        Assert.assertTrue(productsPage.isPageOpened());
        Assert.assertTrue(
                productsPage.areAllProductNamesVisible(),
                "Some of products don't have name or price."
        );
    }
}
