package config;

import org.aeonbits.owner.ConfigFactory;

public class ApiConfigHelper {

    public static String getUrl() { return getConfig().apiUrl(); }

    public static String getToken() {
        return getConfig().apiToken();
    }

    private static ApiConfig getConfig() {
        return ConfigFactory.newInstance().create(ApiConfig.class, System.getProperties());
    }
}
