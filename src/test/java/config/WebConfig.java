package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:local.properties",
        "classpath:remote.properties"
})
public interface WebConfig extends Config {

    @Key("search.url")
    String searchUrl();

    @Key("browser.version")
    String browserVersion();

    @Key("browser.name")
    String browserName();

    @Key("browser.size")
    String browserSize();

    @Key("webdriver.remote")
    String webdriverRemote();
}