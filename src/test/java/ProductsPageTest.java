import laba.pages.ProductsListPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest {
    @Test
    public void testProductListIsDisplayedAfterLogin() {
        ProductsListPage productsPage = loginAsStandardUser();
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened!");

        //Assert.assertTrue(productsPage.areAllProductNamesVisible(), "Not all product names are visible or non-empty!");
    }
}
