package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement searchInput = $(By.name("search"));
    public SelenideElement searchButton = $(By.xpath("//*[contains(@class, 'search-bar')]//button"));
}
