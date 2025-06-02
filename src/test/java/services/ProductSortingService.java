package services;

import java.util.*;

import laba.constants.SortType;
import laba.pages.basePages.ProductsListPageBase;

public class ProductSortingService {
    private final ProductsListPageBase productsPage;

    public ProductSortingService(ProductsListPageBase productsPage) {
        this.productsPage = productsPage;
    }

    public boolean isSortingAppliedCorrectly(SortType sortType) {
        productsPage.selectSortingOption(sortType.getOption());
        switch (sortType) {
            case NAME_A_TO_Z:
            case NAME_Z_TO_A:
                List<String> names = productsPage.getAllProductNames();
                return isSortedProductList(names, sortType);
            case PRICE_LOW_TO_HIGH:
            case PRICE_HIGH_TO_LOW:
                List<Double> prices = productsPage.getAllProductPrices();
                return isSortedProductList(prices, sortType);
            default:
                throw new IllegalArgumentException("Unexpected sort type: " + sortType);
        }
    }

    private <T extends Comparable<T>> boolean isSortedProductList(List<T> list, SortType sortType) {
        List<T> sorted = new ArrayList<>(list);
        switch (sortType) {
            case NAME_A_TO_Z:
            case PRICE_LOW_TO_HIGH:
                Collections.sort(sorted);
                break;
            case NAME_Z_TO_A:
            case PRICE_HIGH_TO_LOW:
                Collections.sort(sorted, Collections.reverseOrder());
                break;
        }
        return sorted.equals(list);
    }
}
