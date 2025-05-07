package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import laba.constants.SortType;
import laba.basePages.ProductsListPage;

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
                List<String> names = productsPage.getAllProductNames();
                return isSorted(names, sortType);
            case PRICE_LOW_TO_HIGH:
            case PRICE_HIGH_TO_LOW:
                List<Double> prices = productsPage.getAllProductPrices();
                return isSorted(prices, sortType);
            default:
                throw new IllegalArgumentException("Unexpected sort type: " + sortType);
        }
    }

    private <T extends Comparable<T>> boolean isSorted(List<T> list, SortType sortType) {
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
