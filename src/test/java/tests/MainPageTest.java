package tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchResultsPage;

@Tag("web")
@Feature("Authorization")
public class MainPageTest extends TestBase {
    private final MainPage mainPage = new MainPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @AllureId("1900")
    @Owner("IMalykh")
    @Feature("Main page")
    @Tag("mainPage")
    @DisplayName("Valid open main page")
    public void search() {
        mainPage.searchInput.setValue("Xiaomi");
        mainPage.searchButton.click();
        searchResultsPage.searchResults.shouldHaveSize(36);
    }
}
