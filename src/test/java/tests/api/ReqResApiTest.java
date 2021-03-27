package tests.api;

import api.model.User;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static api.spec.CustomSpec.spec;
import static api.steps.ApiSteps.extractUserAfterRequest;
import static api.utils.JsonMapper.convertMapToJson;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ReqResApiTest extends ApiTestBase{

    @Test
    @Feature("API")
    @Tag("api")
    @Owner("IMalykh")
    @DisplayName("Check user Model without spec")
    void checkUserRightModelWithoutSpec() {
        User user = extractUserAfterRequest(2);

        assertThat(user.getData().getFirstName(), is("Janet"));
        assertThat(user.getData().getId(), is(2));
        assertThat(user.getData().getLastName(), is("Weaver"));
        assertThat(user.getData().getEmail(), is("janet.weaver@reqres.in"));
    }

    @Test
    @Feature("API")
    @Tag("api")
    @Owner("IMalykh")
    @DisplayName("Check register user with spec")
    void checkRegisterUserWithSpec() {
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
    @Feature("API")
    @Tag("api")
    @Owner("IMalykh")
    @DisplayName("Check list user status code with spec")
    void checkListUserStatusCodeWithSpec() {
        spec().request()
                .get("/users?page=2")
            .then()
                .log().body()
                .statusCode(SC_OK);
    }
}
