package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static config.ConfigHelper.getWebUrl;
import static io.qameta.allure.Allure.step;

public class MainPageTest extends TestBase {

    @Test
    @Feature("Main page")
    @Tag("web")
    @Owner("IMalykh")
    @DisplayName("Valid open main page")
    public void check_main_page_available() {
        step("Open Main page", () -> open(getWebUrl()));
        step("Check is main page open", () -> $("#tbSrch").shouldBe(visible));
    }

    @Test
    @Feature("Search page")
    @Tag("web")
    @Owner("IMalykh")
    @DisplayName("Check search items size on search page")
    public void check_search_for_product() {
        step("Open main page", () -> open(getWebUrl()));
        step("Enter product name", () -> $("#tbSrch").shouldBe(visible).setValue("Xiaomi"));
        step("Click search button", () -> $("#btnSrch").shouldBe(visible).click());

        step("Check search items size is 100", () -> $$(".j-card-item").shouldHaveSize(100));
    }
}
