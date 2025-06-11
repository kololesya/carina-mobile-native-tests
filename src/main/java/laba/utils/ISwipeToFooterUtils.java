package laba.utils;

import com.zebrunner.carina.utils.mobile.IMobileUtils;

import laba.components.common.IFooter;
import static com.zebrunner.carina.utils.mobile.IMobileUtils.Direction.UP;
import static laba.constants.ProjectConstants.SWIPE_DURATION;
import static laba.constants.ProjectConstants.SWIPE_STEPS;

public interface ISwipeToFooterUtils extends IFooter, IMobileUtils {

    default void swipeUpToFooter() {
        swipe(getFooter().getAllRightsReservedLabel(), UP, SWIPE_STEPS, SWIPE_DURATION);
    }
}
