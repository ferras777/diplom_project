package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    public ElementsCollection searchResults = $$(By.xpath("//*[contains(@class, 'search-result-container')]/div/div"));
}
