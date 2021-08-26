package diplom.tests.ui;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static diplom.config.WebConfigHelper.getWebUrl;

@DisplayName("UI Tests")
public class WildberriesTest extends WebTestBase {

    @Test
    @Feature("Main page")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1983")
    @DisplayName("Check main page is opened")
    public void checkMainPageIsOpened() {
        step("Open main page", () -> open(getWebUrl()));

        step("Check main page is opened", () -> $("#tbSrch").shouldBe(visible));
    }

    @Test
    @Feature("Search")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1986")
    @DisplayName("Check search items size on search page")
    public void checkSearchItemsSizeOnSearchPage() {
        step("Open main page", () -> open(getWebUrl()));
        step("Enter product name", () -> $("#tbSrch").setValue("Xiaomi"));
        step("Click search button", () -> $("#btnSrch").click());

        step("Search items size should be 100", () -> $$(".j-card-item").shouldHave(size(100)));
    }

    @Test
    @Feature("Main page")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1985")
    @DisplayName("Check banner should be visible on main page")
    public void checkBannerShouldBeVisibleOnMainPage() {
        step("Open main page", () -> open(getWebUrl()));

        step("Check banner is visible", () -> $("#app").shouldBe(visible));
    }

    @Test
    @Feature("Authorization")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1982")
    @DisplayName("Button get sms code should be visible")
    public void buttonGetSmsCodeShouldBeVisible() {
        step("Open main page", () -> open(getWebUrl()));
        step("Click on enter icon", () -> $("a.user-menu-login").click());

        step("Request code button should be visible with text", () ->
                $("#requestCode").shouldBe(text("ПОЛУЧИТЬ КОД")));
    }

    @Test
    @Feature("Cart")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1981")
    @DisplayName("Check cart button visible and enter into cart")
    public void checkCartButtonVisibleAndEnterIntoCart() {
        step("Open main page", () -> open(getWebUrl()));
        step("Click on cart icon", () -> $(".my-basket").click());

        step("Text should be visible", () -> $(".lk-content").shouldBe(text("Желаем приятных покупок!")));
    }

    @Test
    @Feature("Cart")
    @Tag("web")
    @Owner("IMalykh")
    @AllureId("1984")
    @DisplayName("Add product in cart")
    public void addProductInCart() {
        step("Open main page", () -> open(getWebUrl()));
        step("Enter product name", () -> $("#tbSrch").setValue("Xiaomi"));
        step("Click search button", () -> $("#btnSrch").click());
        step("Click on first product card", () -> $(".j-card-item").click());
        step("Click on add to cart button", () -> $(byText("Добавить в корзину")).click());

        step("Button go in cart visible", () -> $(byText("Перейти в корзину")).shouldBe(visible));

        step("Click on cart icon", () -> $(".my-basket").click());

        step("Product should be added to cart", () -> $(".list-item-wrap").shouldBe(visible));
    }
}
