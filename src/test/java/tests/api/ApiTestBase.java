package tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static api.config.ApiConfigHelper.getApiUrl;

public class ApiTestBase {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = getApiUrl();
    }
}
