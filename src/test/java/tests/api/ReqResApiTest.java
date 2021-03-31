package tests.api;

import api.model.Login;
import api.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static api.spec.CustomSpec.spec;
import static api.steps.ApiSteps.extractUserAfterRequest;
import static api.utils.Json.convertMapToJson;
import static api.utils.Json.convertPOJOToJSON;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@DisplayName("Api Tests")
public class ReqResApiTest extends ApiTestBase{

    @Test
    @Feature("User model")
    @Tag("api")
    @Owner("IMalykh")
    @AllureId("2048")
    @DisplayName("Check user model without spec")
    void checkUserRightModelWithoutSpec() {
        User user = extractUserAfterRequest(2);

        assertThat(user.getData().getFirstName(), is("Janet"));
        assertThat(user.getData().getId(), is(2));
        assertThat(user.getData().getLastName(), is("Weaver"));
        assertThat(user.getData().getEmail(), is("janet.weaver@reqres.in"));
    }

    @Test
    @Feature("Register user")
    @Tag("api")
    @Owner("IMalykh")
    @AllureId("2050")
    @DisplayName("Register user with spec")
    void registerUserWithSpec() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("email", "eve.holt@reqres.in");
        map.put("password", "pistol");

        spec().request(convertMapToJson(map))
            .post("/register")
        .then()
            .log().body()
            .body("id", is(4))
            .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    @Feature("List users")
    @Tag("api")
    @Owner("IMalykh")
    @AllureId("2049")
    @DisplayName("Check list user status code with spec")
    void checkListUserStatusCodeWithSpec() {
        spec().request()
            .get("/users?page=2")
        .then()
            .log().body()
            .statusCode(SC_OK);
    }

    @Test
    @Feature("authorization")
    @Tag("api")
    @Owner("IMalykh")
    @AllureId("2087")
    @DisplayName("Successful login user with model")
    void successfulLoginUserWithModel() throws JsonProcessingException {
        Login login = new Login("eve.holt@reqres.in", "cityslicka");

        spec().request(convertPOJOToJSON(login))
            .post("/login")
        .then()
            .log().body()
            .statusCode(SC_OK)
            .body("token", notNullValue());
    }
}
