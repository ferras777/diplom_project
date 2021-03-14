package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement
            searchInput = $(By.id("tbSrch")),
            searchButton = $(By.id("btnSrch"));
}
