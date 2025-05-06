package services;

import laba.constants.SortType;
import laba.pages.ProductsListPage;

import java.util.List;

public class ProductSortingService {
    private final ProductsListPage productsPage;

    public ProductSortingService (ProductsListPage productsPage) {
        this.productsPage = productsPage;
    }

    public boolean isSortingAppliedCorrectly(SortType sortType) {
        productsPage.selectSortingOption(sortType.getOption());

        switch (sortType) {
            case NAME_A_TO_Z:
            case NAME_Z_TO_A:
                List<String> names = productsPage.getProductNames();
                return productsPage.isSorted(names, sortType);

            case PRICE_LOW_TO_HIGH:
            case PRICE_HIGH_TO_LOW:
                List<Double> prices = productsPage.getProductPrices();
                return productsPage.isSorted(prices, sortType);

            default:
                throw new IllegalArgumentException("Unexpected sort type: " + sortType);
        }
    }
}
