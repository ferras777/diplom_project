package ui.config;

import org.aeonbits.owner.ConfigFactory;

import static java.lang.Boolean.parseBoolean;

public class WebConfigHelper {

    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }

    public static String getWebBrowser() {
        return getWebConfig().webBrowser();
    }

    public static String getRemoteDriverUrl() { return getWebConfig().webRemoteDriverUrl(); }

    public static String getWebRemoteDriver() {
        return "https://" + getWebConfig().webRemoteDriverUser() + ":" +
                getWebConfig().webRemoteDriverPassword() + "@" +
                getWebConfig().webRemoteDriverUrl() + "/wd/hub";
    }

    public static boolean isRemoteWebDriver() {
        return !getWebConfig().webRemoteDriverUrl().equals("");
    }

    public static String getWebVideoStorage() {
        return "https://" + getRemoteDriverUrl() + "/video/";
    }

    public static boolean isVideoOn() {
        return parseBoolean(System.getProperty("video"));
    }

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}
