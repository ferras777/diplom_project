package api.config;

import org.aeonbits.owner.ConfigFactory;

public class ApiConfigHelper {

    public static String getApiUrl() { return getApiConfig().apiUrl(); }

    private static ApiConfig getApiConfig() {
        return ConfigFactory.newInstance().create(ApiConfig.class, System.getProperties());
    }
}
