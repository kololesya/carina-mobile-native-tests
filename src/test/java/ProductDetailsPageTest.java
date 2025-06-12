import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import laba.model.Product;
import laba.pages.base.ProductDetailsPageBase;
import laba.pages.base.ProductsListPageBase;
import static laba.constants.ProjectConstants.SAUCE_LABS_ONESIE;

public class ProductDetailsPageTest extends BaseTest {

    @Test
    public void testOpenProductDetailsPage() {
        ProductsListPageBase productsPage = loginAsStandardUser();
        ProductDetailsPageBase productDetailsPage = productsPage.openProductByName(SAUCE_LABS_ONESIE);
        Assert.assertTrue(productDetailsPage.isPageOpened(), "Product details page was not opened.");
        Assert.assertEquals(productDetailsPage.getProductName(), SAUCE_LABS_ONESIE, "Product name doesn't match!");
    }

    @Test
    public void testProductInfoConsistency() {
        ProductsListPageBase productsPage = loginAsStandardUser();
        Product product = productsPage.getProductFromListByName(SAUCE_LABS_ONESIE);
        ProductDetailsPageBase detailsPage = productsPage.openProductByName(SAUCE_LABS_ONESIE);
        Product productFromDetails = detailsPage.mapToProduct();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(
                productFromDetails.getProductTitle(),
                product.getProductTitle(),
                "The name of the product doesn't match!"
        );

        softAssert.assertEquals(
                productFromDetails.getProductPrice(),
                product.getProductPrice(),
                "The price of the product doesn't match"
        );

        softAssert.assertTrue(
                detailsPage.isProductImageDisplayed(),
                "The image of the product doesn't exist"
        );

        softAssert.assertAll();
    }
}
