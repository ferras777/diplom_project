package drivers;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.WebDriverProvider;
import config.WebConfigHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class CustomWebDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        capabilities.setBrowserName(Browsers.CHROME);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("videoFrameRate", 24);

        capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
        WebDriverManager.chromedriver().setup();

        if(WebConfigHelper.getWebdriverRemote() != null) {
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(getRemoteWebdriverUrl(), capabilities);
            remoteWebDriver.setFileDetector(new LocalFileDetector());

            return remoteWebDriver;
        } else {
            return new ChromeDriver(capabilities);
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--lang=ru");

        return chromeOptions;
    }

    private URL getRemoteWebdriverUrl() {
        try {
            return new URL(WebConfigHelper.getWebdriverRemote() + ":4444/wd/hub/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
