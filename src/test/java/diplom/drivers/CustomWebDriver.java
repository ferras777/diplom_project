package diplom.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static diplom.config.WebConfigHelper.*;

public class CustomWebDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        addListener("AllureSelenide", new AllureSelenide().screenshots(false).savePageSource(false));

        capabilities.setCapability("enableVNC", true);
        if (isVideoOn()) {
            capabilities.setCapability("enableVideo", true);
            capabilities.setCapability("videoFrameRate", 24);
        }

        if (isRemoteWebDriver()) {
            switch (getWebBrowser()) {
                case "chrome":
                    capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
                    WebDriverManager.chromedriver().setup();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    break;
                default:
                    throw new IllegalStateException("Wrong browser name: " + getWebBrowser());
            }
            return getRemoteWebDriver(capabilities);
        } else {
            switch (getWebBrowser()) {
                case "chrome":
                    return getLocalChromeDriver();
                case "firefox":
                    return getLocalFirefoxDriver();
                default:
                    throw new IllegalStateException("Wrong browser name: " + getWebBrowser());
            }
        }
    }

    private ChromeDriver getLocalChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(getChromeOptions());
    }

    private FirefoxDriver getLocalFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver getRemoteWebDriver(DesiredCapabilities capabilities) {
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(getRemoteWebDriverUrl(), capabilities);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-gpu");

        return chromeOptions;
    }

    private URL getRemoteWebDriverUrl() {
        try {
            return new URL(getWebRemoteDriver());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
