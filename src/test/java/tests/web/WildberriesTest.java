package tests.web;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static config.ConfigHelper.getWebUrl;
import static io.qameta.allure.Allure.step;

public class WildberriesTest extends WebTestBase {

    @Test
    @Feature("Main page")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1983")
    @DisplayName("Valid open main page")
    public void check_main_page_available() {
        step("Open Main page", () -> open(getWebUrl()));

        step("Check is main page open", () -> $("#tbSrch").shouldBe(visible));
    }

    @Test
    @Feature("Search page")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1986")
    @DisplayName("Check search items size on search page")
    public void check_search_items_size_on_search_page() {
        step("Open main page", () -> open(getWebUrl()));
        step("Enter product name", () -> $("#tbSrch").shouldBe(visible).setValue("Xiaomi"));
        step("Click search button", () -> $("#btnSrch").shouldBe(visible).click());

        step("Check search items size is 100", () -> $$(".j-card-item").shouldHaveSize(100));
    }

    @Test
    @Feature("Main page")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1985")
    @DisplayName("Check banner visible on main page")
    public void check_banner_visible_on_main_page() {
        step("Open main page", () -> open(getWebUrl()));

        step("Check is banner visible", () -> $("#app").shouldBe(visible));
    }

    @Test
    @Feature("Authorization")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1982")
    @DisplayName("Check get sms code button visible")
    public void check_get_sms_code_button_visible() {
        step("Open main page", () -> open(getWebUrl()));
        step("Click on enter icon", () -> $("a.user-menu-login").shouldBe(visible)).click();

        step("Request code button should be visible with text",
                () -> $("#requestCode").shouldBe(visible)).shouldBe(text("ПОЛУЧИТЬ КОД"));
    }

    @Test
    @Feature("Cart")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1981")
    @DisplayName("Check cart button visible and enter into cart")
    public void check_cart_button_visible_and_enter_into_cart() {
        step("Open main page", () -> open(getWebUrl()));
        step("Click on cart icon", () -> $(".my-basket").shouldBe(visible)).click();

        step("Text should be visible",
                () -> $(".lk-content").shouldBe(visible)).shouldBe(text("Желаем приятных покупок!"));
    }

    @Test
    @Feature("Cart")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1984")
    @DisplayName("Add product in cart")
    public void add_product_in_cart() {
        step("Open main page", () -> open(getWebUrl()));
        step("Enter product name", () -> $("#tbSrch").shouldBe(visible).setValue("Xiaomi"));
        step("Click search button", () -> $("#btnSrch").shouldBe(visible).click());
        step("Click on first product card", () -> $(".j-card-item").click());
        step("Click on add to cart button", () -> $(byText("Добавить в корзину")).click());
        step("Button go in cart visible", () -> $(byText("Перейти в корзину")).shouldBe(visible));
        step("Click on cart icon", () -> $(".my-basket").shouldBe(visible)).click();

        step("Product should be added to cart",
                () -> $(".list-item-wrap").shouldBe(visible));
    }

    @Test
    @Feature("Cart")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1987")
    @DisplayName("Add product in cart failed")
    public void add_product_in_cart_failed() {
        step("Open main page", () -> open(getWebUrl()));
        step("Enter product name", () -> $("#tbSrch").shouldBe(visible).setValue("Xiaomi"));
        step("Click search button", () -> $("#btnSrch").shouldBe(visible).click());
        step("Click on first product card", () -> $(".j-card-item").click());
        step("Click on add to cart button", () -> $(".order")).click();
        step("Button go in cart visible", () -> $(byText("Перейти в корзину")).shouldBe(visible));
        step("Click on cart icon", () -> $(".my-basket").shouldBe(visible)).click();

        step("Product should be added to cart",
                () -> $(".list-item-wrap").shouldBe());
    }
}
