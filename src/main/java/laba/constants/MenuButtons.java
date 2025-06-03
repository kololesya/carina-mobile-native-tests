package laba.constants;

public enum MenuButtons {

    ALL_ITEMS("ALL ITEMS"),
    WEBVIEW("WEBVIEW"),
    QR_CODE_SCANNER("QR CODE SCANNER"),
    GEO_LOCATION("GEO LOCATION"),
    DRAWING("DRAWING"),
    ABOUT("ABOUT"),
    LOGOUT("LOGOUT"),
    RESET_APP_STATE("RESET APP STATE");

    private final String accessibilityId;

    MenuButtons(String accessibilityId) {
        this.accessibilityId = accessibilityId;
    }

    public String getAccessibilityId() {
        return accessibilityId;
    }
}
