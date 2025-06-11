package laba.utils;

import com.zebrunner.carina.utils.mobile.IMobileUtils;

import laba.components.common.FooterComponent;
import static com.zebrunner.carina.utils.mobile.IMobileUtils.Direction.UP;
import static laba.constants.ProjectConstants.SWIPE_DURATION;
import static laba.constants.ProjectConstants.SWIPE_STEPS;

public interface ISwipeToFooterUtils extends IMobileUtils {

    FooterComponent getFooter();

    default void swipeUpToFooter() {
        swipe(getFooter().getAllRightsReservedLabel(), UP, SWIPE_STEPS, SWIPE_DURATION);
    }
}
