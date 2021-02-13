package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchResultsPage;

public class MainPageTest extends TestBase {
    private final MainPage mainPage = new MainPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    public void search() {
        mainPage.searchInput.setValue("Xiaomi");
        mainPage.searchButton.click();
        searchResultsPage.searchResults.shouldHaveSize(36);
    }
}
