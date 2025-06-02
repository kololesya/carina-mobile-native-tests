package laba.utils;

import java.math.*;
import java.util.regex.*;

public class PriceUtils {

    private static final Pattern PRICE_PATTERN = Pattern.compile("[^\\d.,]");

    public static BigDecimal extractPrice(String rawPriceText) {
        if (rawPriceText == null || rawPriceText.isEmpty()) {
            throw new IllegalArgumentException("Price text cannot be null or empty");
        }
        String cleaned = PRICE_PATTERN.matcher(rawPriceText).replaceAll("").replace(",", ".");
        return new BigDecimal(cleaned);
    }
}
