import laba.basePages.ProductsListPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest {

    @Test
    public void testProductListIsDisplayedAfterLogin() {
        ProductsListPage productsPage = loginAsStandardUser();
        Assert.assertTrue(
                productsPage.areAllProductNamesVisible(),
                "Some of products don't have name or price."
        );
    }
}
