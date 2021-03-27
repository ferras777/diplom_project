package api.steps;

import api.model.User;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ApiSteps {

    @Step("Проверка модели пользователя с ID#{userId}")
    public static User extractUserAfterRequest(int userId) {
        return given()
                    .filter(new AllureRestAssured())
                    .log().uri()
                .when()
                    .get("/users/" + userId)
                .then()
                    .log().body()
                    .statusCode(SC_OK)
                    .extract()
                    .as(User.class);
    }
}
