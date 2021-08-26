package diplom.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/web.properties"
})
public interface WebConfig extends Config {
    @Key("web.url")
    String webUrl();

    @Key("web.browser")
    String webBrowser();

    @Key("remote.driver.url")
    String webRemoteDriverUrl();

    @Key("remote.driver.user")
    String webRemoteDriverUser();

    @Key("remote.driver.password")
    String webRemoteDriverPassword();
}
