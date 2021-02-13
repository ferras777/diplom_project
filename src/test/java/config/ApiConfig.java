package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:~/api.properties",
        "system:properties"
})
public interface ApiConfig extends Config {

    @DefaultValue("https://ya.ru")
    @Key("api.url")
    String apiUrl();

    @DefaultValue("123qwe123qwe")
    @Key("api.token")
    String apiToken();
}