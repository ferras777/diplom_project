package diplom.spec;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class CustomSpec {

    public RequestSpecification request(String body) {
        return given()
                    .contentType(JSON)
                    .body(body)
                    .filter(new AllureRestAssured())
                    .log().all()
                .when();
    }

    public RequestSpecification request() {
        return given()
                    .contentType(JSON)
                    .filter(new AllureRestAssured())
                    .log().all()
                .when();
    }

    public static CustomSpec spec() {
        return new CustomSpec();
    }
}
