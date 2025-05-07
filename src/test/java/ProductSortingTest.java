import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import laba.constants.SortType;
import laba.basePages.ProductsListPage;
import services.ProductSortingService;

public class ProductSortingTest extends BaseTest {

    @DataProvider(name = "sortingOptions")
    public Object[][] sortingOptions() {
        return new Object[][] {
                { SortType.NAME_A_TO_Z },
                { SortType.NAME_Z_TO_A },
                { SortType.PRICE_LOW_TO_HIGH },
                { SortType.PRICE_HIGH_TO_LOW }
        };
    }

    @Test(dataProvider = "sortingOptions")
    public void testProductSorting(SortType sortType) {
        ProductsListPage productsPage = loginAsStandardUser();
        ProductSortingService inventorySortingService = new ProductSortingService(productsPage);
        Assert.assertTrue(inventorySortingService.isSortingAppliedCorrectly(sortType),
                "Products are sorted correctly by " + sortType);
    }
}
