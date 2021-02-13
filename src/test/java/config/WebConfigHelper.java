package config;

import org.aeonbits.owner.ConfigFactory;

public class WebConfigHelper {

    public static String getSearchUrl() {
        return getConfig().searchUrl();
    }

    public static String getBrowserVersion() {
        return getConfig().browserVersion();
    }

    public static String getBrowserName() {
        return getConfig().browserName();
    }

    public static String getWebdriverRemote() {
        return getConfig().webdriverRemote();
    }

    public static String getBrowserSize() {
        return getConfig().browserSize();
    }

    private static WebConfig getConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }
}
