package laba.utils;

import com.zebrunner.carina.utils.R;

public class DeviceUtils {

    public static boolean isUnstableDevice() {
        String device = R.CONFIG.get("capabilities.deviceName");
        String version = R.CONFIG.get("capabilities.platformVersion");
        String unstableDevice = R.TESTDATA.get("unstable.deviceName");
        String unstableVersion = R.TESTDATA.get("unstable.platformVersion");
        return unstableDevice.equals(device) && unstableVersion.equals(version);
    }
}
