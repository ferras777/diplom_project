package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.CustomWebDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static config.ConfigHelper.getWebUrl;
import static org.openqa.selenium.logging.LogType.BROWSER;


public class DriverHelper {

    public static void configureDriver() {
        addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true).savePageSource(true));

        Configuration.browser = CustomWebDriver.class.getName();
        Configuration.baseUrl = getWebUrl();

        Configuration.timeout = 10000;
    }

    public static String getSessionId(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid","");
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }

//    public static String getNetworkLogs() {
//        todo https://ru.selenide.org/2019/12/18/advent-calendar-network-logs-with-proxy/
//    }
}