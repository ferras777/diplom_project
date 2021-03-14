package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchResultsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static config.ConfigHelper.getWebUrl;
import static io.qameta.allure.Allure.step;

@Tag("web")
@Owner("IMalykh")
@Feature("Authorization")
public class MainPageTest extends TestBase {
    private final MainPage mainPage = new MainPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @AllureId("1900")
    @Feature("Main page")
    @Tag("mainPage")
    @DisplayName("Valid open main page")
    public void search() {
        step("Open Main page", () -> open(getWebUrl()));
        step("Check is main page open", () -> mainPage.searchInput.shouldBe(visible));
    }
}
