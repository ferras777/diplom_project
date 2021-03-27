package config;

import api.config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;

import static java.lang.Boolean.parseBoolean;

public class ConfigHelper {

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

    public static String getApiUrl() { return getApiConfig().apiUrl(); }

    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

    private static ApiConfig getApiConfig() {
        return ConfigFactory.newInstance().create(ApiConfig.class, System.getProperties());
    }
}
