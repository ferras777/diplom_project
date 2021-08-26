package diplom.steps;

import diplom.model.User;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class ApiSteps {

    @Step("Запрос модели пользователя с ID#{userId}")
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

    @Step("Проверка модели пользователя")
    public static void checkUserModel(User user) {
        assertThat(user.getData().getFirstName(), notNullValue());
        assertThat(user.getData().getId(), notNullValue());
        assertThat(user.getData().getLastName(), notNullValue());
        assertThat(user.getData().getEmail(), notNullValue());
        assertThat(user.getData().getAvatar(), notNullValue());
        assertThat(user.getSupport().getText(), notNullValue());
        assertThat(user.getSupport().getUrl(), notNullValue());
    }
}
