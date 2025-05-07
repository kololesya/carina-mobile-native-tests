import laba.androidPages.ProductsListPageAndroid;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest {

    @Test
    public void testProductListIsDisplayedAfterLogin() {
        ProductsListPageAndroid productsPage = (ProductsListPageAndroid) loginAsStandardUser();
        Assert.assertTrue(
                productsPage.areAllProductNamesVisible(),
                "Some of products don't have name or price."
        );
    }
}
